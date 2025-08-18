package org.example.domain.itinerary.controller;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.itinerary.service.ItineraryService;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.example.globals.exceptions.InvalidItineraryTimeException;

public class ItineraryController {
    private final TripService tripService = new TripService();
    private final ItineraryService itineraryService = new ItineraryService();
    private final OutputView outputView;
    private final InputView inputView;

    /** 특정 Trip의 itineraries를 조회/출력하고, 실제 리스트를 반환 */
    public List<Itinerary> itineraries = new ArrayList<>();

    public ItineraryController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
//
//    public List<Itinerary> getIterineriesFromTrips(int targetTripId) {
//        List<Trip> allTrips = tripService.initialMappingJsonFile();
//        Optional<Trip> foundTrip = allTrips.stream()
//                .filter(trip -> trip.getTrip_id() == targetTripId)
//                .findFirst();
//
//        if (foundTrip.isEmpty()) {
//            outputView.printError("해당 ID의 여행이 없습니다: " + targetTripId);
//            return Collections.emptyList();
//        }
//
//        List<Itinerary> list = itineraryService.listByTripId(targetTripId);
//        outputView.printItineraryList(list, targetTripId);
//        return list;
//    }

    /** 명세: 일정 여러 개 입력(Y/N) */
    public void inputItinearyData() {

        int selectTripInputId = goInputTripId();

        boolean continueInput = true;
        while (continueInput) {
            try {
                collectAndSaveItinerary(selectTripInputId);
                outputView.sucessSaveItineraryInfoMessage();

                int chooseRetry = inputView.inputData();
                if (chooseRetry == 2) {
                    continueInput = false;
                }
                
            } catch (InvalidItineraryTimeException e) {
                outputView.showError(e.getMessage());
                continueInput = askForRetry();
            } catch (Exception e) {
                outputView.showError(e.getMessage());
                continueInput = askForRetry();
            }
        }
    }

    private int goInputTripId() {
        boolean isHasTrip;
        int selectTripInputId;
        do {
            getAllTripViewToItineraryInput();
            selectTripInputId = inputView.inputData();
            isHasTrip = itineraryService.hasTripId(selectTripInputId);
            if(!isHasTrip) {
                outputView.noTripIdOutput();
            }
        } while(!isHasTrip);

        return selectTripInputId;
    }

    private void collectAndSaveItinerary(int tripId) {
        outputView.startItineraryInputStartMessage();

        outputView.tripRequestItineraryOrigin();
        String tripOriginName = inputView.inputDataStr();

        outputView.tripRequestItineraryDestination();
        String tripDestination = inputView.inputDataStr();

        outputView.tripRequestItineraryOriginTime();
        String tripOriginTime = inputView.inputDataStrTime();

        outputView.tripRequestItineraryDestinationTime();
        String tripDestinationTime = inputView.inputDataStrTime();

        outputView.tripRequestItineraryCheckInTime();
        String tripCheckInTime = inputView.inputDataStrTime();

        outputView.tripRequestItineraryCheckOutTime();
        String tripCheckOutTime = inputView.inputDataStrTime();
        
        itineraryService.saveItineraryInfo(tripId, tripOriginName, tripDestination, tripOriginTime, tripDestinationTime, tripCheckInTime, tripCheckOutTime);
    }

    private boolean askForRetry() {
        outputView.requestRetryMessage();
        int retryChoice = inputView.inputData();
        return retryChoice == 1;
    }

    private void getAllTripViewToItineraryInput() {
        List<Trip> getTrips = tripService.findAllTrips();
        outputView.viewerGetTrips(getTrips);
    }
}

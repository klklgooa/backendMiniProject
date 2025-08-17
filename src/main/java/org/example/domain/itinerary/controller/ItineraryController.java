package org.example.domain.itinerary.controller;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.itinerary.service.ItineraryService;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.globals.exceptions.InvalidItineraryTimeException;

public class ItineraryController {
    public TripService tripService = new TripService();
    public ItineraryService itineraryService = new ItineraryService();
    public List<Itinerary> itineraries = new ArrayList<>();

    private final OutputView outputView;
    private final InputView inputView;

    public ItineraryController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public List<Itinerary> getIterineriesFromTrips(int targetTripId) {
        List<Trip> allTrips = tripService.initialMappingJsonFile();
        Optional<Trip> foundTrip = allTrips.stream()
                .filter(trip -> trip.getTrip_id() == targetTripId)
                .findFirst();

        foundTrip.ifPresent(trip -> {
            List<Itinerary> itineraries = trip.getItineraries();

            System.out.println("--- Trip ID: " + trip.getTrip_id() + "의 itineraries ---");
            itineraries.forEach(itinerary -> {
                System.out.println("  - Itinerary ID: " + itinerary.getItinerary_id());
                System.out.println("    Departure: " + itinerary.getDeparture_place() + " at " + itinerary.getDeparture_time());
                System.out.println("    Destination: " + itinerary.getDestination() + " at " + itinerary.getArrival_time());
                System.out.println("    Check-in: " + itinerary.getCheck_in());
                System.out.println("    Check-out: " + itinerary.getCheck_out());
                System.out.println("---------------------------------------------");
            });
        });
        return itineraries;
    }

    public void inputItinearyData() {
        getAllTripViewToItineraryInput();
        int selectTripInputId = inputView.inputData();

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

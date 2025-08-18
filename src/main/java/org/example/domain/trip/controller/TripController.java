package org.example.domain.trip.controller;

import org.example.domain.itinerary.repository.ItineraryRepository;
import org.example.domain.itinerary.service.ItineraryService;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.List;

public class TripController {
    private final TripService tripService = new TripService();;
    private final ItineraryService itineraryService = new ItineraryService();
    private final TripRepository tripRepository = new TripRepository();

    private final OutputView outputView;
    private final InputView inputView;

    public TripController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initialMappingJsonFile() {
        tripService.initialMappingJsonFile();
    }

    public void inputTripsData() {
        while(true) {
            outputView.startTripRecordMessage();
            int isInputTripRecord = inputView.inputDataInRange(1,2);
            if(isInputTripRecord==1) {
                inputTripRecord();
            }
            if(isInputTripRecord==2) {
                break;
            }
        }
    }

    private void inputTripRecord() {
        outputView.startTripRecordInputMessage();

        outputView.startTripInputNameMessage();
        String name = inputView.inputDataStr();

        outputView.tripInputStartDateMessage();
        String startDate = inputView.inputDataStrDate();

        outputView.tripInputStopDateMessage();
        String stopDate = inputView.inputDataStrDate();

        try {
            tripService.createTrip(name, startDate, stopDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public List<Trip> getTripList() {
        List<Trip> tripList = tripService.initialMappingJsonFile(); // get 수정해야함
        outputView.printTripList(tripList);
        return tripList;
    }

    public void getTotalViewTripInfo() {
        List<Trip> getTrips = tripService.findAllTrips();
        outputView.viewerGetTrips(getTrips);
        int getTripId = inputView.inputData();

        while(!tripRepository.hasTripId(getTripId)) {
            outputView.noTripIdOutput();
            getTripId = inputView.inputData();
        }

        Trip TripInfo = tripService.findTripById(getTripId);
        if(!itineraryService.hasItineraries(TripInfo)) {
            outputView.printNoIterierary();
        }else {
            outputView.printItineraryList(TripInfo);
        }
    }
}
package org.example.domain.orchestration.controller;

import org.example.domain.itinerary.controller.ItineraryController;
import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.controller.TripController;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.List;

public class OrchestrationController {

    ItineraryController itineraryController = new ItineraryController();
    TripController tripController = new TripController();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        process(this::initialMappingJsonFile);
        process(this::welcomStartTrip);
    }

    private void initialMappingJsonFile() {
        tripController.initialMappingJsonFile();
    }
<<<<<<< HEAD
=======


>>>>>>> 6fd98619cc24557056165dc1e45b688c0733d3df
    private void task2_test() {
        outputView.testPrintMessage();
        List<Itinerary> itineraryListOfTripId = itineraryController.getIterineriesFromTrips(1);
        List<Trip> tripList = tripController.getTripList();
    }
  
    private void welcomStartTrip() {
        while(true) {
            outputView.welcomStartTravelMessage();
            int initInputData = inputView.inputData();
            goToInitialSelecterInputData(initInputData);

            if(initInputData==4) {
                outputView.stopTravelMessage();
                break;
            }
        }
    }

    private void goToInitialSelecterInputData(int initInputData) {
        switch (initInputData) {
            case 1:
                tripController.inputTripsData();
                break;
            case 2:
                itineraryController.inputItinearyData();
                break;
            case 3:
                tripController.getTotalViewTripInfo();
                break;
        }
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
//            outputView.exception(e);
            action.run();
            throw e;
        }
    }
}

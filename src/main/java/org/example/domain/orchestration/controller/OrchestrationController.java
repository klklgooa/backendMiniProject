package org.example.domain.orchestration.controller;

import org.example.domain.itinerary.controller.ItineraryController;
import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.controller.TripController;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.outputView.OutputView;

import java.util.List;

public class OrchestrationController {

    ItineraryController itineraryController = new ItineraryController();
    TripController tripController = new TripController();

    OutputView outputView = new OutputView();

    public void run() {
        process(this::initialMappingJsonFile);
        process(this::task2_test);
    }

    private void initialMappingJsonFile() {
        tripController.initialMappingJsonFile();
    }

    private void task2_test() {
        outputView.testPrintMessage();
        List<Itinerary> itineraryListOfTripId = itineraryController.getIterineriesFromTrips(1);
        List<Trip> tripList = tripController.getTripList();
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

package org.example.domain.orchestration.controller;

import org.example.domain.itinerary.controller.ItineraryController;
import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.controller.TripController;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.globals.exceptions.ExitException;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

public class OrchestrationController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    ItineraryController itineraryController = new ItineraryController(inputView, outputView);
    TripController tripController = new TripController(inputView, outputView);


    public void run() {
        process(this::initialMappingJsonFile);
        process(this::welcomStartTrip);
    }

    private void initialMappingJsonFile() {
        tripController.initialMappingJsonFile();
    }

    private void welcomStartTrip() {
        while(true) {
            try {
                outputView.welcomStartTravelMessage();
                int initInputData = inputView.inputDataInRange(1, 4);

                // 4번(종료)이 아닌 경우에만 goTo... 메서드 호출
                if (initInputData == 4) {
                    outputView.stopTravelMessage();
                    break;
                }

                goToInitialSelecterInputData(initInputData);

            } catch (ExitException e) {
                outputView.testPrintMessage();
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
            System.out.println(e.getMessage());
        }
    }

}

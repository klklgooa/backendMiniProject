package org.example.domain.trip.controller;

import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

public class TripController {
    TripService tripService = new TripService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void initialMappingJsonFile() {
        tripService.getTrip();
    }

    public void inputTripsData() {
        while(true) {
            outputView.startTripRecordMessage();
            int isInputTripRecord = inputView.inputData();
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
        String StartDate = inputView.inputDataStr();

        outputView.tripInputStopDateMessage();
        String StopDate = inputView.inputDataStr();

    }


    public void getTotalViewTripInfo() {

    }
}

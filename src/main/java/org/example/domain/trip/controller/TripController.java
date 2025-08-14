package org.example.domain.trip.controller;

import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

public class TripController {
    TripService tripService = new TripService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public TripController() {}

    public void initialMappingJsonFile() {
        tripService.getTrip();

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

    public void create(String trip_name, String start_date, String end_date) {
        tripService.createTrip(trip_name, start_date, end_date);
    }

    public void findTripById(int trip_id) {
        tripService.findTripById(trip_id);
    }
}

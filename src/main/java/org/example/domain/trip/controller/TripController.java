package org.example.domain.trip.controller;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.List;

public class TripController {
    private final TripService tripService = new TripService();;

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

        Trip getTripInfo = tripService.findTripById(getTripId);
        outputView.viewerGetTripInfos(getTripInfo);
    }

}

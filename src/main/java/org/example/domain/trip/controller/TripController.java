package org.example.domain.trip.controller;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;

import java.util.List;

public class TripController {
    TripService tripService = new TripService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public TripController() {}

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

        tripService.createTrip(name, startDate, stopDate);
    }

    public List<Trip> getTripList() {
        List<Trip> tripList = tripService.initialMappingJsonFile();
        tripList.stream().forEach(trip -> {
            System.out.println("  - 여행 ID: " + trip.getTrip_id());
            System.out.println("  - 여행 이름: " + trip.getTrip_name());
            System.out.println("  - 여행 시작 날짜: " + trip.getStart_date());
            System.out.println("  - 여행 종료 날짜: " + trip.getEnd_date());
        });
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

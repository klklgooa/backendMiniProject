package org.example.domain.trip.controller;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;
import org.example.domain.trip.service.TripService;

import java.io.IOException;
import java.util.List;

public class TripController {
    TripService tripService = new TripService();

    public void initialMappingJsonFile() {
        tripService.getTrip();
    }

    public List<Trip> getTripList() {
        List<Trip> tripList = tripService.getTrip();
        tripList.stream().forEach(trip -> {
            System.out.println("  - 여행 ID: " + trip.getTrip_id());
            System.out.println("  - 여행 이름: " + trip.getTrip_name());
            System.out.println("  - 여행 시작 날짜: " + trip.getStart_date());
            System.out.println("  - 여행 종료 날짜: " + trip.getEnd_date());
        });
        return tripList;
    }
}

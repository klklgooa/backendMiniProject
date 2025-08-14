package org.example.domain.trip.controller;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;
import org.example.domain.trip.service.TripService;

import java.io.IOException;
import java.util.List;

public class TripController {
    TripService tripService = new TripService();

    public TripController() {}

    public void initialMappingJsonFile() {
        tripService.getTrip();
    }

    public void create(String trip_name, String start_date, String end_date) {
        tripService.createTrip(trip_name, start_date, end_date);
    }

    public void findTripById(int trip_id) {
        tripService.findTripById(trip_id);
    }
}

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
}

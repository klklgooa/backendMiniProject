package org.example.domain.trip.service;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;

public class TripService {
    private TripRepository tripRepository = new TripRepository();

    public void createTrip(String trip_name, String start_date, String end_date) {
        Trip trip = new Trip(trip_name, start_date, end_date);
        tripRepository.saveTrip(trip);
    }


}

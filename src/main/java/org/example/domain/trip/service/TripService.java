package org.example.domain.trip.service;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;
import org.example.globals.utils.TimeValidator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TripService {
    private final TripRepository tripRepository = new TripRepository();

    public void createTrip(String trip_name, String start_date, String end_date) {
        TimeValidator.validateTripDates(start_date, end_date);
        Trip trip = new Trip(trip_name, start_date, end_date);
        tripRepository.addTrip(trip);
    }

    public Trip findTripById(int trip_id) {
        return tripRepository.findTripById(trip_id);
    }

    public List<Trip> findAllTrips() {
        try {
            List<Trip> trips = tripRepository.findAllTrips();
            return trips;
        } catch (Exception e) {

            return null;
        }
    }

    public List<Trip> initialMappingJsonFile() {
        try {
            return tripRepository.loadAllTrips();
        } catch (IOException e) {
            System.err.println("JSON 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}

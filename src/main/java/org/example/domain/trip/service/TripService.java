package org.example.domain.trip.service;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class TripService {
    private TripRepository tripRepository = new TripRepository();
    private static List<Trip> trips;

    public void createTrip(String trip_name, String start_date, String end_date) {
        Trip trip = new Trip(trip_name, start_date, end_date);
        tripRepository.saveTrip(trip);
    }

    public List<Trip> getTrip() {
        if (trips == null) try {
            // 런타임 시작 시 모든 JSON 파일을 읽어 trips 객체에 저장
            trips = tripRepository.loadAllTrips();

        } catch (IOException e) {
            System.err.println("JSON 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
        return trips;
    }
}

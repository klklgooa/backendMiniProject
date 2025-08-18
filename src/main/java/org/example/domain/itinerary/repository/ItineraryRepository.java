package org.example.domain.itinerary.repository;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItineraryRepository {

    private final TripRepository tripRepository = new TripRepository();

    /** 특정 여행의 모든 일정 조회 */
    public List<Itinerary> findByTripId(int tripId) {
        Trip trip = tripRepository.findTripById(tripId);
        if (trip == null) return Collections.emptyList();
        List<Itinerary> list = trip.getItineraries();
        return (list == null) ? Collections.emptyList() : new ArrayList<>(list);
    }

    /** 특정 여행에 일정 추가 후 저장 */
    public void addToTrip(int tripId, Itinerary newItinerary) {
        Trip trip = tripRepository.findTripById(tripId);
        if (trip == null) {
            throw new IllegalArgumentException("존재하지 않는 여행 ID: " + tripId);
        }

        // itinerary_id 발급 (해당 trip 내 최대값 + 1)
        int nextId = trip.getItineraries().stream()
                .map(Itinerary::getItinerary_id)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) + 1;
        newItinerary.setItinerary_id(nextId);

        trip.getItineraries().add(newItinerary);

        tripRepository.saveTrip(trip);
    }
}

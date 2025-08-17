package org.example.domain.itinerary.service;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.itinerary.repository.ItineraryRepository;

import java.util.List;
import java.util.Objects;

public class ItineraryService {

    private final ItineraryRepository itineraryRepository = new ItineraryRepository();

    public List<Itinerary> listByTripId(int tripId) {
        return itineraryRepository.findByTripId(tripId);
    }

    public void addToTrip(int tripId, Itinerary it) {
        validate(it);
        itineraryRepository.addToTrip(tripId, it);
    }

    public void addToTrip(int tripId, String departurePlace, String destination,
                          String departureTime, String arrivalTime, String checkIn, String checkOut) {
        Itinerary it = new Itinerary(0, departurePlace, destination, departureTime, arrivalTime, checkIn, checkOut);
        addToTrip(tripId, it);
    }

    private void validate(Itinerary it) {
        Objects.requireNonNull(it, "여정이 없습니다.");
        if (isBlank(it.getDeparture_place())) throw new IllegalArgumentException("출발지는 필수입니다.");
        if (isBlank(it.getDestination())) throw new IllegalArgumentException("도착지는 필수입니다.");
        if (isBlank(it.getDeparture_time())) throw new IllegalArgumentException("출발 시간은 필수입니다.");
        if (isBlank(it.getArrival_time())) throw new IllegalArgumentException("도착 시간은 필수입니다.");
        if (isBlank(it.getCheck_in())) throw new IllegalArgumentException("체크인 시간은 필수입니다.");
        if (isBlank(it.getCheck_out())) throw new IllegalArgumentException("체크아웃 시간은 필수입니다.");
    }

    private boolean isBlank(String s) { return s == null || s.isBlank(); }
}

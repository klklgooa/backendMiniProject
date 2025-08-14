package org.example.domain.itinerary.controller;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItineraryController {
    public static TripService tripService = new TripService();
    public static List<Itinerary> itineraries = new ArrayList<>();

    public List<Itinerary> getIterineriesFromTrips(int targetTripId) {
        List<Trip> allTrips = tripService.getTrip();
        Optional<Trip> foundTrip = allTrips.stream()
                .filter(trip -> trip.getTrip_id() == targetTripId)
                .findFirst();

        foundTrip.ifPresent(trip -> {
            List<Itinerary> itineraries = trip.getItineraries();

            System.out.println("--- Trip ID: " + trip.getTrip_id() + "의 itineraries ---");
            itineraries.forEach(itinerary -> {
                System.out.println("  - Itinerary ID: " + itinerary.getItinerary_id());
                System.out.println("    Departure: " + itinerary.getDeparture_place() + " at " + itinerary.getDeparture_time());
                System.out.println("    Destination: " + itinerary.getDestination() + " at " + itinerary.getArrival_time());
                System.out.println("    Check-in: " + itinerary.getCheck_in());
                System.out.println("    Check-out: " + itinerary.getCheck_out());
                System.out.println("---------------------------------------------");
            });
        });
        return itineraries;
    }

    public void inputItinearyData() {
    }
}

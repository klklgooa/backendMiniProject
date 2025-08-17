package org.example.domain.itinerary.service;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.itinerary.repository.ItineraryRepository;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;

import java.util.List;

public class ItineraryService {
    private static final TripRepository tripRepository  = new TripRepository();
    private static final ItineraryRepository itineraryRepository = new ItineraryRepository();

    public List<Itinerary> listByTripId(int tripId) {
        return itineraryRepository.findByTripId(tripId);
    }

    public void saveItineraryInfo(int selectTripInputId, String tripOriginName, String tripDestination, String tripOriginTime, String tripDestinationTime, String tripCheckInTime, String tripCheckOutTime) {
        Trip getMytripInfo = tripRepository.findTripById(selectTripInputId);
        List<Itinerary> itineraries = getMytripInfo.getItineraries();

        int checkItineraryInfoCount = 0;
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getItinerary_id() > checkItineraryInfoCount) {
                checkItineraryInfoCount = itinerary.getItinerary_id();
            }
        }

        Itinerary itinerary = new Itinerary(checkItineraryInfoCount+1, tripOriginName, tripDestination, tripOriginTime, tripDestinationTime, tripCheckInTime, tripCheckOutTime);
        tripRepository.saveItineraryInfo(selectTripInputId, itinerary);

    }

}

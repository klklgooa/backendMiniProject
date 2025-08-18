package org.example.domain.trip.entity;

import org.example.domain.itinerary.entity.Itinerary;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private int trip_id;
    private String trip_name;
    private String start_date;
    private String end_date;
    private List<Itinerary> itineraries = new ArrayList<>();

    public Trip() {}

    public Trip(String trip_name, String start_date, String end_date) {
        this.trip_name = trip_name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getTrip_id() {
        return this.trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }
}
package org.example.domain.itinerary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.globals.exceptions.InvalidItineraryTimeException;
import org.example.globals.utils.TimeValidator;

import java.time.LocalDateTime;

public class Itinerary {

    @JsonProperty("itinerary_id")
    private int itinerary_id;

    @JsonProperty("departure_place")
    private String departure_place;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("departure_time")
    private String departure_time;

    @JsonProperty("arrival_time")
    private String arrival_time;

    @JsonProperty("check_in")
    private String check_in;

    @JsonProperty("check_out")
    private String check_out;

    public Itinerary() {}

    public Itinerary(int itinerary_id, String departure_place, String destination, String departure_time, String arrival_time, String check_in, String check_out) {
        this.itinerary_id = itinerary_id;
        this.departure_place = departure_place;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.check_in = check_in;
        this.check_out = check_out;
        validateTimes();
    }

    private void validateTimes() {
        try {
            TimeValidator.validateItineraryTimes(departure_time, arrival_time, check_in, check_out);
        } catch (IllegalArgumentException e) {
            throw new InvalidItineraryTimeException(e.getMessage());
        }
    }

    public String getDestination() {
        return destination;
    }

    public int getItinerary_id() {
        return itinerary_id;
    }

    public void setItinerary_id(int itinerary_id) {
        this.itinerary_id = itinerary_id;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }
}

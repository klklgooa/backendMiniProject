package org.example.domain.itinerary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    }
}

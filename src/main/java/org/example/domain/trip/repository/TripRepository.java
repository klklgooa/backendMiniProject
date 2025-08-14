package org.example.domain.trip.repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.domain.trip.entity.Trip;

import java.io.File;
import java.io.IOException;

public class TripRepository {
    private static final String FILE_PATH = "";
    private final ObjectMapper objectMapper;

    // objcectMapper: 자바 객체 <-> json or json <-> 자바 객체로 매핑해주는 역할
    // JavaTimeModule(): java.time 패키지의 날짜·시간 타입을 변환해주는 역할
    public TripRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        File dir = new File(FILE_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public Trip findTripById(int trip_id) {
        try {
            File file = new File(FILE_PATH, "trip_" + trip_id + ".json");
            if(!file.exists()) return null;
            return objectMapper.readValue(file, Trip.class);
        } catch (IOException e) {
            throw new RuntimeException("Trip 파일을 읽는 데 실패했습니다.", e);
        }
    }

    public void saveTrip(Trip trip) {
        try {
            File file = new File(FILE_PATH, "trip_" + trip.getTrip_id() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, trip);
        } catch (IOException e) {
            throw new RuntimeException("Trip 파일을 저장하는데 데 실패했습니다.", e);
        }
    }
}

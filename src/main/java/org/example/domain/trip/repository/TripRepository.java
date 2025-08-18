package org.example.domain.trip.repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.trip.entity.Trip;
import org.example.globals.exceptions.ErrorMessage;
import org.example.globals.exceptions.FileLoadException;
import org.example.globals.utils.FileNo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    private static final String FILE_PATH = "src/main/resources";
    private final ObjectMapper objectMapper;
    private static final List<Trip> trips = new ArrayList<>();

    // objcectMapper: 자바 객체 <-> json or json <-> 자바 객체로 매핑해주는 역할
    // JavaTimeModule(): java.time 패키지의 날짜·시간 타입을 변환해주는 역할
    public TripRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Trip> loadAllTrips() throws IOException {
        String dataDirPath = FILE_PATH;
        File dataDir = new File(dataDirPath);

        if (dataDir.exists() && dataDir.isDirectory()) {
            File[] jsonFiles = dataDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

            if (jsonFiles != null) {
                for (File jsonFile : jsonFiles) {
                    Trip trip = objectMapper.readValue(jsonFile, Trip.class);
                    trips.add(trip);
                }
            }
        }
        return trips;
    }

    public Trip findTripById(int trip_id) {
        try {
            File file = new File(FILE_PATH, "trip_" + trip_id + ".json");
            if(!file.exists()) return null;
            return objectMapper.readValue(file, Trip.class);
        } catch (IOException e) {
            throw new FileLoadException(ErrorMessage.FILE_NOT_LOADED_READ_ERROR.getMessage(), e);
        }
    }

    public boolean hasTripId(int trip_id) {
        return trips.stream()
                .anyMatch(trip -> trip_id == trip.getTrip_id());
    }


    public void saveTrip(Trip trip) {
        try {
            File file = new File(FILE_PATH, "trip_" + trip.getTrip_id() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, trip);

            boolean exists = false;
            for (int i = 0; i < trips.size(); i++) {
                if (trips.get(i).getTrip_id() == trip.getTrip_id()) {
                    trips.set(i, trip);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                trips.add(trip);
            }

        } catch (IOException e) {
            throw new FileLoadException(ErrorMessage.FILE_NOT_LOADED_READ_ERROR.getMessage(), e);
        }
    }

    public void addTrip(Trip trip) {
        FileNo FileNo = new FileNo();
        int newId = FileNo.getNextFileNo();
        trip.setTrip_id(newId);
        saveTrip(trip);
    }

    public List<Trip> findAllTrips() {
        return trips;
    }

}

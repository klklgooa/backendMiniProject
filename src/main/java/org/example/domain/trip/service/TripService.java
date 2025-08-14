package org.example.domain.trip.service;

import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.repository.TripRepository;

import java.io.IOException;
import java.util.List;

public class TripService {
    private TripRepository tripRepository = new TripRepository();
    private static List<Trip> trips;

    public void createTrip(String trip_name, String start_date, String end_date) {
        Trip trip = new Trip(trip_name, start_date, end_date);
        tripRepository.saveTrip(trip);
    }

    public void getTrip() {
        try {
            // 런타임 시작 시 모든 JSON 파일을 읽어 trips 객체에 저장
            trips = tripRepository.loadAllTrips();

            // 데이터 확인 및 활용
            System.out.println("총 " + trips.size() + "개의 여행 정보가 로드되었습니다.");
            trips.forEach(trip -> {
                System.out.println("Trip Name: " + trip.getTrip_name() + ", Trip ID: " + trip.getTrip_id());
            });

            // 예시: 새로운 Trip을 추가하는 로직
//            Trip newTrip = new Trip();
//            // ... 새 Trip 데이터 설정 ...
//            trips.add(newTrip);

            // 예시: 기존 Trip의 정보 업데이트
            if (!trips.isEmpty()) {
                Trip firstTrip = trips.get(0);
                firstTrip.setTrip_name("Updated Family Vacation");
                System.out.println("첫 번째 여행 정보가 업데이트되었습니다: " + firstTrip.getTrip_name());
            }

        } catch (IOException e) {
            System.err.println("JSON 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package org.example.domain.itinerary.controller;

import org.example.domain.itinerary.entity.Itinerary;
import org.example.domain.itinerary.service.ItineraryService;
import org.example.domain.trip.entity.Trip;
import org.example.domain.trip.service.TripService;
import org.example.view.inputView.InputView;
import org.example.view.outputView.OutputView;
import org.example.view.outputView.OutputViewMessage;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ItineraryController {
    private final TripService tripService = new TripService();
    private final ItineraryService itineraryService = new ItineraryService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    /** 특정 Trip의 itineraries를 조회/출력하고, 실제 리스트를 반환 */
    public List<Itinerary> getIterineriesFromTrips(int targetTripId) {
        List<Trip> allTrips = tripService.getTrip();
        Optional<Trip> foundTrip = allTrips.stream()
                .filter(trip -> trip.getTrip_id() == targetTripId)
                .findFirst();

        if (foundTrip.isEmpty()) {
            outputView.printError("해당 ID의 여행이 없습니다: " + targetTripId);
            return Collections.emptyList();
        }

        List<Itinerary> list = itineraryService.listByTripId(targetTripId);
        outputView.printItineraryList(list, targetTripId);
        return list;
    }

    /** 명세: 일정 여러 개 입력(Y/N) */
    public void inputItinearyData() {
        System.out.println("일정을 추가할 여행 ID를 입력하세요:");
        int tripId = inputView.inputData();

        while (true) {
            System.out.println("출발지:");
            String departurePlace = inputView.inputDataStr();

            System.out.println("도착지:");
            String destination = inputView.inputDataStr();

            System.out.println("출발 시간(예: 2023-07-15T08:00:00):");
            String departureTime = inputView.inputDataStr();

            System.out.println("도착 시간(예: 2023-07-15T10:00:00):");
            String arrivalTime = inputView.inputDataStr();

            System.out.println("체크인(예: 2023-07-15T12:00:00):");
            String checkIn = inputView.inputDataStr();

            System.out.println("체크아웃(예: 2023-07-30T10:00:00):");
            String checkOut = inputView.inputDataStr();

            try {
                itineraryService.addToTrip(tripId, departurePlace, destination, departureTime, arrivalTime, checkIn, checkOut);
                System.out.println("일정이 저장되었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("저장 실패: " + e.getMessage());
            }

            System.out.println("일정을 계속 추가하시겠습니까? (Y/N)");
            String yn = inputView.inputDataStr();
            if (!"Y".equalsIgnoreCase(yn)) break;
        }
    }
}

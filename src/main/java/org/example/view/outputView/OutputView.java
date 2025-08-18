package org.example.view.outputView;
import org.example.domain.trip.entity.Trip;
import org.example.domain.itinerary.entity.Itinerary;
import java.util.List;

import org.example.domain.trip.entity.Trip;

import java.util.List;

public class OutputView {

    private void printMessage(String msg) { System.out.println(msg); }

    // 공통 유틸 추가
    public void printTitle(String title) {
        System.out.println("============ " + title + " ============");
    }

    public void printSuccess(String msg) {
        System.out.println("[성공] " + msg);
    }

    public void printError(String msg) {
        System.out.println("[오류] " + msg);
    }

    public void testPrintMessage() {
        printMessage(OutputViewMessage.TRIP_INITIAL_START_MESSAGE_PRINT.getMessage());
    }
    public void welcomStartTravelMessage() {
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_INITIAL_START_MESSAGE_SERVICE.getMessage());
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_MESSAGE.getMessage());
    }

    public void startTripRecordMessage() {
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_RECORD_START_MESSAGE.getMessage());
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_RECORD_REQUEST_MESSAGE.getMessage());

    }

    public void stopTravelMessage() {
        printMessage(OutputViewMessage.TRIP_STOP_MESSAGE.getMessage());
    }

    public void startTripRecordInputMessage() {
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_TRAVEL_RECORD_INPUT_MESSAGE.getMessage());
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
    }

    public void startTripInputNameMessage() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_TRIP_MESSAGE.getMessage());
    }

    public void tripInputStartDateMessage() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_START_DATE.getMessage());
    }

    public void tripInputStopDateMessage() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_STOP_DATE.getMessage());
    }


    // 여정, 여행에서 쓰이는 헬퍼들
    public void printTrip(Trip t) {
        if (t == null) { printError("여행 정보가 없습니다."); return; }
        System.out.print(t.getTrip_id() + " || " );
        System.out.print(t.getTrip_name() + " || " );
        System.out.print(t.getStart_date() + " || " );
        System.out.println(t.getEnd_date());
    }

    public void printTripList(List<Trip> trips) {
        if (trips == null || trips.isEmpty()) {
            printMessage("등록된 여행이 없습니다.");
            return;
        }
        printMessage(OutputViewMessage.TRIP_OUTPUT_COLUMN.getMessage());
        trips.forEach(this::printTrip);
    }

    public void printItinerary(Itinerary it) {
        System.out.print(it.getItinerary_id() + " || ");
        System.out.print(it.getDeparture_place() + " || ");
        System.out.print(it.getDestination() + " || ");
        System.out.print(it.getDeparture_time() + " || ");
        System.out.print(it.getArrival_time() + " || ");
        System.out.print(it.getCheck_in()  + " || ");
        System.out.println(it.getCheck_out()  + " || ");
    }

    public void printItineraryList(Trip trip) {
        printMessage(OutputViewMessage.ITINERARY_OUTPUT_COLUMN.getMessage());
        trip.getItineraries().forEach(this::printItinerary);
    }

    public void startItineraryInputStartMessage() {
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_START_MESSAGE.getMessage());
        printMessage(OutputViewMessage.TRIP_MESSAGE_PRIFIX.getMessage());
    }

    public void tripRequestItineraryOrigin() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_ORIGIN_MESSAGE.getMessage());
    }
    public void tripRequestItineraryDestination() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_DESTINATION_MESSAGE.getMessage());
    }
    public void tripRequestItineraryOriginTime() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_ORIGIN_TIME_MESSAGE.getMessage());
    }

    public void tripRequestItineraryDestinationTime() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_DESTINATION_TIME_MESSAGE.getMessage());
    }

    public void tripRequestItineraryCheckInTime() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_CHECK_IN_MESSAGE.getMessage());
    }
    public void tripRequestItineraryCheckOutTime() {
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_ITINERARY_CHECK_OUT_MESSAGE.getMessage());
    }

    public void sucessSaveItineraryInfoMessage() {
        printMessage(OutputViewMessage.ITINERARY_INPUT_SUCCESS_MESSAGE.getMessage());
        printMessage(OutputViewMessage.ITINERARY_INPUT_RETRY_MESSAGE.getMessage());
    }
    public void sucessSaveTripInfoMessage() {
        printMessage(OutputViewMessage.TRIP_INPUT_SUCCESS_MESSAGE.getMessage());
        printMessage(OutputViewMessage.ITINERARY_INPUT_RETRY_MESSAGE.getMessage());
    }

    public void showError(String errorMessage) {
        printMessage(errorMessage);
    }

    public void requestRetryMessage() {
        printMessage(OutputViewMessage.ITINERARY_INPUT_RETRY_MESSAGE.getMessage());
    }

    public void noTripIdOutput() {
        printMessage(OutputViewMessage.NO_TRIP_ID_OUTPUT_MESSAGE.getMessage());
    }

    public void viewerGetTrips(List<Trip> getTrips) {
        printTripList(getTrips);
        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_TO_ITINERARY_MESSAGE.getMessage());
    }

    public void printNoIterierary() {
        printMessage(OutputViewMessage.NO_ITINERARY_MESSAGE.getMessage());
    }
}

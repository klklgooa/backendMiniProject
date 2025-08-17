package org.example.view.outputView;

import org.example.domain.trip.entity.Trip;

import java.util.List;

public class OutputView {

    private void printMessage(String msg) { System.out.println(msg); }

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

    public void showError(String errorMessage) {
        printMessage(errorMessage);
    }

    public void requestRetryMessage() {
        printMessage(OutputViewMessage.ITINERARY_INPUT_RETRY_MESSAGE.getMessage());
    }


    public void viewerGetTrips(List<Trip> getTrips) {

        // 여행 출력 해야함~

        printMessage(OutputViewMessage.TRIP_INPUT_REQUEST_TO_ITINERARY_MESSAGE.getMessage());
    }

    public void viewerGetTripInfos(Trip getTripInfo) {

    }
}

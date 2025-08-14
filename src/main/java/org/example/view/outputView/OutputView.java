package org.example.view.outputView;

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
}

package org.example.view.outputView;

public class OutputView {

    private void printMessage(String msg) { System.out.println(msg); }

    public void testPrintMessage() {
        printMessage(OutputViewMessage.TRIP_INITIAL_START_MESSAGE_PRINT.getMessage());

    }
}

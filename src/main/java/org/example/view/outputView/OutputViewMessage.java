package org.example.view.outputView;

public enum OutputViewMessage {
    TRIP_INITIAL_START_MESSAGE_PRINT("여행 플랫폼을 오신것을 환영합니다~!");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

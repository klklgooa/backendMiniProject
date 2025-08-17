package org.example.view.outputView;

public enum OutputViewMessage {
    TRIP_MESSAGE_PRIFIX("============"),
    TRIP_INITIAL_START_MESSAGE_SERVICE("여행 정보 플랫폼"),
    TRIP_INPUT_REQUEST_MESSAGE("여행 기록 (1), 여정 기록 (2), 여행 및 여정 조회 (3), 종료 (4)"),
    TRIP_STOP_MESSAGE("***** 여행 플랫폼을 종료합니다. *****"),
    TRIP_RECORD_START_MESSAGE("여행기록"),
    TRIP_RECORD_REQUEST_MESSAGE("여행 기록 입력 (1), 메인으로 가기 (2)"),

    TEST("test"),
    TRIP_TRAVEL_RECORD_INPUT_MESSAGE("여행기록 입력"),
    TRIP_INPUT_REQUEST_TRIP_MESSAGE("여행 이름:"),
    TRIP_INPUT_REQUEST_START_DATE("시작 날짜"),
    TRIP_INPUT_REQUEST_STOP_DATE("종료 날짜"),
    TRIP_INITIAL_START_MESSAGE_PRINT("여행 플랫폼에 오신것을 환영합니다~!"),

    ITINERARY_INPUT_TRIP_ID("일정을 추가할 여행 ID:"),
    ITINERARY_INPUT_DEPARTURE("출발지:"),
    ITINERARY_INPUT_DESTINATION("도착지:"),
    ITINERARY_INPUT_DEPARTURE_TIME("출발 시간(예: 2023-07-15T08:00:00):"),
    ITINERARY_INPUT_ARRIVAL_TIME("도착 시간(예: 2023-07-15T10:00:00):"),
    ITINERARY_INPUT_CHECKIN("체크인(예: 2023-07-15T12:00:00):"),
    ITINERARY_INPUT_CHECKOUT("체크아웃(예: 2023-07-30T10:00:00):");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

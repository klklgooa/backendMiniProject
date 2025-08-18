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

    TRIP_INPUT_REQUEST_START_DATE("시작 날짜:"),
    TRIP_INPUT_REQUEST_STOP_DATE("종료 날짜:"),
    TRIP_INITIAL_START_MESSAGE_PRINT("여행 플랫폼에 오신것을 환영합니다~!"),

    TRIP_INPUT_REQUEST_TO_ITINERARY_MESSAGE("여행 아이디를 입력해주세요. :"),
    TRIP_INPUT_REQUEST_ITINERARY_START_MESSAGE("여정기록 입력"),
    TRIP_INPUT_REQUEST_ITINERARY_ORIGIN_MESSAGE("출발지:"),
    TRIP_INPUT_REQUEST_ITINERARY_DESTINATION_MESSAGE("도착지:"),
    TRIP_INPUT_REQUEST_ITINERARY_ORIGIN_TIME_MESSAGE("출발시각:"),
    TRIP_INPUT_REQUEST_ITINERARY_DESTINATION_TIME_MESSAGE("도착시각:"),
    TRIP_INPUT_REQUEST_ITINERARY_CHECK_IN_MESSAGE("체크인:"),
    TRIP_INPUT_REQUEST_ITINERARY_CHECK_OUT_MESSAGE("체크아웃:"),
    TRIP_OUTPUT_COLUMN("여행 ID || 여행 이름 || 여행 시작 날짜 || 여행 종료 날짜"),
    ITINERARY_INPUT_SUCCESS_MESSAGE("Itinerary가 저장되었습니다."),
    ITINERARY_INPUT_RETRY_MESSAGE("계속 입력하시겠습니까? (1: 계속, 2: 종료)"),
    ITINERARY_OUTPUT_COLUMN("여정 ID || 출발지 || 도착지 || 출발_시간 || 도착_시간 || 체크인 || 체크아웃");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

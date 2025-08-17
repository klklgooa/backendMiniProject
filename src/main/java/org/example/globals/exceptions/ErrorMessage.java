package org.example.globals.exceptions;

public enum ErrorMessage {
    INVALID_TIME_FORMAT("잘못된 시간 형식입니다. YYYY/MM/DD-HH:mm 형식으로 입력해주세요."),
    INVALID_DATE_FORMAT("잘못된 날짜 형식입니다. YYYY/MM/DD 형식으로 입력해주세요."),
    ARRIVAL_BEFORE_DEPARTURE("도착 시간이 출발 시간보다 빠를 수 없습니다."),
    FILE_NOT_LOADED_SAVE_ERROR("Trip 파일을 저장하는데 데 실패했습니다."),
    FILE_NOT_LOADED_READ_ERROR("Trip 파일을 읽는 데 실패했습니다."),
    CHECKOUT_BEFORE_CHECKIN("체크아웃 시간이 체크인 시간보다 빠를 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

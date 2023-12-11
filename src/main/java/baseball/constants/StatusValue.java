package baseball.constants;

import java.util.List;

public enum StatusValue {
    CONTINUE_NUMBER("1"),
    BREAK_NUMBER("2");

    private String number;

    StatusValue(String number) {
        this. number = number;
    }

    private String getNumber() {
        return number;
    }

    public static boolean validate(String number) {
        List<StatusValue> values = List.of(StatusValue.values());

        for (StatusValue value : values) {
            if (value.getNumber().equals(number)) {
                return true;
            }
        }
        throw new IllegalArgumentException("1또는 2를 입력해주세요.");
    }

    public static boolean getStatus(String number) {
        if (number.equals(StatusValue.CONTINUE_NUMBER.getNumber())) {
            return true;
        }
        return false;
    }
}

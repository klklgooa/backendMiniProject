package org.example.view.inputView;

import org.example.globals.exceptions.InputException;
import org.example.globals.utils.InputValidator;

import java.util.Scanner;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    private final Scanner scanner = new Scanner(System.in);

    /** 숫자 1개 입력 (잘못 입력하면 재시도) */
    public int inputData() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("올바른 숫자를 입력하세요: ");
            }
        }
    }

    public int inputDataInRange(int min, int max) {
        while (true) {
            int value = inputData();

            if (value < min || value > max) {
                System.out.print("숫자 범위를 벗어났습니다. (" + min + " ~ " + max + "): ");
            } else {
                return value;
            }
        }
    }

    /** 공백 포함 문자열 입력 */
    public String inputDataStr() {
        while (true) {
            String line = scanner.nextLine();
            if (line != null && !line.isBlank()) return line;
            System.out.print("빈 값입니다. 다시 입력하세요: ");
        }
    }

    public String inputDataStrDate() {
        while(true){
            try {
                String input = scanner.next();
                return InputValidator.validateAndFormatDate(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputDataStrTime() {
        while(true){
            try {
                String input = scanner.next();
                return InputValidator.validateAndFormatDateTime(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputStart() {
        String rawInput = scanner.nextLine();
        int number = convertToInt(rawInput);
        inputValidator.validateInitialInput(number);
        return number;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException("숫자를 입력해야 합니다.");
        }
    }
}

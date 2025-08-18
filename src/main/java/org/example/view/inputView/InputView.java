package org.example.view.inputView;

import org.example.globals.exceptions.ExitException;
import org.example.globals.exceptions.InputException;
import org.example.globals.utils.InputValidator;

import java.util.Scanner;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    private final Scanner scanner = new Scanner(System.in);

    private String readUserInput() {
        String input = scanner.nextLine();
        if ("exit".equalsIgnoreCase(input.trim())) {
            throw new ExitException("메인으로 이동합니다");
        }
        return input;
    }

    /** 숫자 1개 입력 (잘못 입력하면 재시도) */
    public int inputData() {
        while (true) {
            String line = readUserInput();
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

    public String inputDataStr() {
        while (true) {
            try{
                String line = readUserInput();
                if (line != null && !line.isBlank()) return line;
                System.out.print("빈 값입니다. 다시 입력하세요: ");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputDataStrDate() {
        while(true){
            try {
                String input = readUserInput();
                return InputValidator.validateAndFormatDate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputDataStrTime() {
        while(true){
            try {
                String input = readUserInput();
                return InputValidator.validateAndFormatDateTime(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException("숫자를 입력해야 합니다.");
        }
    }
}

package org.example.view.inputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

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

    /** 공백 포함 문자열 입력 */
    public String inputDataStr() {
        while (true) {
            String line = scanner.nextLine();
            if (line != null && !line.isBlank()) return line;
            System.out.print("빈 값입니다. 다시 입력하세요: ");
        }
    }

}

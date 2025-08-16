package org.example.view.inputView;

import org.example.globals.exceptions.InputException;
import org.example.globals.utils.InputValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputData() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    public String inputDataStr() {
        return scanner.next();
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
}

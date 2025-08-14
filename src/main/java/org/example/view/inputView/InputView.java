package org.example.view.inputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

    public int inputData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputDataStr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}

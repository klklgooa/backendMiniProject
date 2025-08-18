package org.example;

import org.example.domain.orchestration.controller.OrchestrationController;
import org.example.globals.utils.FileNo;

public class Main {
    public static void main(String[] args) {
        OrchestrationController orchestrationController = new OrchestrationController();
        orchestrationController.run();

    }
}
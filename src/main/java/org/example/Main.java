package org.example;

import org.example.domain.orchestration.controller.OrchestrationController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        OrchestrationController orchestrationController = new OrchestrationController();
        orchestrationController.run();
    }
}
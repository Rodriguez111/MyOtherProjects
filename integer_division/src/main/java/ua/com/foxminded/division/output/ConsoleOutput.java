package ua.com.foxminded.division.output;

import ua.com.foxminded.division.maths.Step;

import java.util.List;

public class ConsoleOutput implements Output {
    @Override
    public void outputResult(List<Step> listOfSteps) {
        for (Step eachStep : listOfSteps) {
            System.out.print(eachStep.getPrintStep());
        }

    }
}

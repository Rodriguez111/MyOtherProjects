package ua.com.foxminded.division.formatting;

import ua.com.foxminded.division.maths.BarDividing;
import ua.com.foxminded.division.maths.Step;
import ua.com.foxminded.division.output.Output;

import java.util.List;

public abstract class Format {
    private Output output;
    private  BarDividing barDividing = new BarDividing();

    String spaceSymbol = " ";
    String underscoreSymbol = "_";
    String hyphenSymbol = "-";
    String verticalBarSymbol = "|";
    String spaceBefore = "";
    String spaceAfter = "";
    String formOutput = "";
    String lineSeparator = System.lineSeparator();
    int underscoreLength = 1;
    int verticalBarSymbolLength = 1;
    int offsetOfSubtrahend = 0;
    int offsetOfSubtract = 0;
    int margin = 0;

    public Format(Output output) {
        this.output = output;
    }


    abstract void formatFirstStep(List<Step> listOfSteps);
    abstract void formatOtherSteps(List<Step> listOfSteps);
    //abstract void formatReminder(Step step);

    public void formatResult(int number1, int number2) {
        List<Step> listOfSteps = barDividing.calculate(number1, number2);
        formatFirstStep(listOfSteps);
        if (listOfSteps.size() > 1) {
            formatOtherSteps(listOfSteps);
        }
        output.outputResult(listOfSteps);
    }

     void formatReminder(Step step) {
        spaceBefore = composeCharacterSequence(spaceSymbol, margin + step.getRemainderOffset());
        formOutput = spaceBefore + step.getDifference() + lineSeparator;
        step.setPrintStep(formOutput);
    }

    String composeCharacterSequence(String character, int spaceAmount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < spaceAmount; i++) {
            sequence.append(character);
        }
        return sequence.toString();
    }
}


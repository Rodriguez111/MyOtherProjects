package ua.com.foxminded.division.formatting;

import ua.com.foxminded.division.maths.Step;
import ua.com.foxminded.division.output.Output;
import ua.com.foxminded.division.utils.Utils;

import java.util.List;

public class BritishFormat extends Format {

    public BritishFormat(Output output) {
        super(output);
    }

    @Override
    void formatFirstStep(List<Step> listOfSteps) {
        int dividend = listOfSteps.get(0).getSubtrahend();
        int globalResult = listOfSteps.get(0).getGlobalResult();
        int divider = listOfSteps.get(0).getDivider();
        if (listOfSteps.get(0).getSubtrahend() < 0) {
            spaceBefore += spaceSymbol;
            margin++;
        }
        String value = String.valueOf(globalResult);
        formOutput = formOutput(Utils.digitsAmount(divider), value);
        listOfSteps.get(0).setPrintStep(formOutput);
        formOutput = spaceBefore + composeCharacterSequence(hyphenSymbol, Utils.digitsAmount(globalResult)) + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        formOutput = divider + verticalBarSymbol + dividend + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        spaceBefore = composeCharacterSequence(spaceSymbol, margin + Utils.digitsAmount(divider) + verticalBarSymbolLength + listOfSteps.get(0).getOffsetOfSubtract());
        formOutput = spaceBefore + listOfSteps.get(0).getSubtract() + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        formOutput = spaceBefore + composeCharacterSequence(hyphenSymbol, Utils.digitsAmount(listOfSteps.get(0).getSubtract())) + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        margin = margin + Utils.digitsAmount(divider) + verticalBarSymbolLength;

        if (listOfSteps.size() == 1) {
            formatReminder(listOfSteps.get(listOfSteps.size() - 1));
        }
    }

    @Override
    void formatOtherSteps(List<Step> listOfSteps) {
        for (int i = 1; i < listOfSteps.size(); i++) {
            offsetOfSubtrahend = margin + listOfSteps.get(i).getOffsetOfSubtrahend();
            offsetOfSubtract = margin + listOfSteps.get(i).getOffsetOfSubtract();
            String subtrahend = String.valueOf(listOfSteps.get(i).getSubtrahend());
            formOutput = formOutput(offsetOfSubtrahend, subtrahend);
            listOfSteps.get(i).setPrintStep(formOutput);
            String subtract = String.valueOf(listOfSteps.get(i).getSubtract());
            formOutput = formOutput(offsetOfSubtract, subtract);
            listOfSteps.get(i).setPrintStep(formOutput);
            String separator = composeCharacterSequence(hyphenSymbol, Utils.digitsAmount(listOfSteps.get(i).getSubtract()));
            formOutput = formOutput(offsetOfSubtract, separator);
            listOfSteps.get(i).setPrintStep(formOutput);
        }
        formatReminder(listOfSteps.get(listOfSteps.size() - 1));

    }

    String formOutput(int offset, String value) {
        spaceBefore = composeCharacterSequence(spaceSymbol, offset);
        return spaceBefore + value + lineSeparator;
    }

}

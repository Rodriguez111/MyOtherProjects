package ua.com.foxminded.division.formatting;


import ua.com.foxminded.division.maths.Step;
import ua.com.foxminded.division.output.Output;
import ua.com.foxminded.division.utils.Utils;

import java.util.List;

public class BelgiumFormat extends Format {

    public BelgiumFormat(Output output) {
        super(output);
    }

    void formatFirstStep(List<Step> listOfSteps) {
        margin = underscoreLength;
        if (listOfSteps.get(0).getSubtrahend() < 0) {
            int minesLength = 1;
            margin += minesLength;
        }
        int dividend = listOfSteps.get(0).getSubtrahend();
        int globalResult = listOfSteps.get(0).getGlobalResult();
        formOutput = underscoreSymbol + dividend + verticalBarSymbol + listOfSteps.get(0).getDivider() + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        spaceBefore = composeCharacterSequence(spaceSymbol,  listOfSteps.get(0).getOffsetOfSubtract() + margin);
        int afterSpaceLength = Utils.digitsAmount(Math.abs(dividend)) - Utils.digitsAmount(listOfSteps.get(0).getSubtract()) - listOfSteps.get(0).getOffsetOfSubtract();

        spaceAfter = composeCharacterSequence(spaceSymbol,  afterSpaceLength);
        int hyphenLength = Utils.digitsAmount(listOfSteps.get(0).getGlobalResult());
        String hyphens = composeCharacterSequence(hyphenSymbol, hyphenLength);
        formOutput = spaceBefore + listOfSteps.get(0).getSubtract() + spaceAfter + verticalBarSymbol + hyphens + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        hyphenLength = Utils.digitsAmount(listOfSteps.get(0).getSubtract());
        hyphens = composeCharacterSequence(hyphenSymbol, hyphenLength);
        afterSpaceLength = Utils.digitsAmount(Math.abs(dividend)) - listOfSteps.get(0).getOffsetOfSubtract() - hyphenLength;
        spaceAfter = composeCharacterSequence(spaceSymbol,  afterSpaceLength);
        formOutput = spaceBefore + hyphens + spaceAfter + verticalBarSymbol + globalResult + lineSeparator;
        listOfSteps.get(0).setPrintStep(formOutput);
        if (listOfSteps.size() == 1) {
            formatReminder(listOfSteps.get(listOfSteps.size() - 1));
        }
    }

    @Override
    void formatOtherSteps(List<Step> listOfSteps) {
        for (int i = 1; i < listOfSteps.size(); i++) {
          int offsetOfSubtrahend = margin + listOfSteps.get(i).getOffsetOfSubtrahend();
          int offsetOfSubtract = margin + listOfSteps.get(i).getOffsetOfSubtract();
            spaceBefore = composeCharacterSequence(spaceSymbol, offsetOfSubtrahend  - underscoreLength);
            formOutput = spaceBefore + underscoreSymbol + listOfSteps.get(i).getSubtrahend() + lineSeparator;
            listOfSteps.get(i).setPrintStep(formOutput);
            spaceBefore = composeCharacterSequence(spaceSymbol, offsetOfSubtract);
            formOutput = spaceBefore + listOfSteps.get(i).getSubtract() + lineSeparator;
            listOfSteps.get(i).setPrintStep(formOutput);
            spaceBefore = composeCharacterSequence(spaceSymbol, offsetOfSubtract);
            formOutput = spaceBefore + composeCharacterSequence(hyphenSymbol, Utils.digitsAmount(listOfSteps.get(i).getSubtract())) + lineSeparator;
            listOfSteps.get(i).setPrintStep(formOutput);
        }
        formatReminder(listOfSteps.get(listOfSteps.size() - 1));
    }

}

package ua.com.foxminded.division.maths;

import ua.com.foxminded.division.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BarDividing {
    Calculation divide = new Divide();
    Calculation multiply = new Multiply();
    int offsetOfSubtrahend;
    int offsetOfSubtract;

    public List<Step> calculate(int number1, int number2) {
        Utils.inputValidate(number1, number2);
       int absDividend = Math.abs(number1);
       int absDivider = Math.abs(number2);
        int[] dividendArray = Utils.getDigits(absDividend);
        List<Step> listOfSteps = new ArrayList<>();
        int currentSubtrahend = 0;
        for (int i = 0; i < dividendArray.length; i++) {
            currentSubtrahend = multiply.calculate(currentSubtrahend, 10) + dividendArray[i];
            if (currentSubtrahend >= absDivider) {
                int partOfResult = divide.calculate(currentSubtrahend, absDivider);
                int currentSubtract = multiply.calculate(partOfResult, absDivider);
                offsetOfSubtrahend = i + 1 - Utils.digitsAmount(currentSubtrahend);
                offsetOfSubtract = i + 1 - Utils.digitsAmount(currentSubtract);
                //Step step = new Step(currentSubtrahend, currentSubtract, 0);
                Step step = new Step(currentSubtrahend, currentSubtract, 0, offsetOfSubtrahend, offsetOfSubtract);
                currentSubtrahend -= currentSubtract;
                step.setDifference(currentSubtrahend);
                listOfSteps.add(step);
            }
        }
        listOfSteps.get(listOfSteps.size() - 1).setDifference(currentSubtrahend);
        int reminderOffset = dividendArray.length - Utils.digitsAmount(currentSubtrahend);
        listOfSteps.get(listOfSteps.size() - 1).setRemainderOffset(reminderOffset);
        listOfSteps.get(0).setSubtrahend(number1);
        listOfSteps.get(0).setDivider(number2);
        listOfSteps.get(0).setGlobalResult(divide.calculate(number1, number2));
        return listOfSteps;
    }
}

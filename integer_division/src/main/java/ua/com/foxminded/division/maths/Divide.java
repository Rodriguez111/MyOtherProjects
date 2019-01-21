package ua.com.foxminded.division.maths;

public class Divide extends Calculation {

    public int calculate(int number1, int number2) {
        if (number2 == 0) {
            throw new UnsupportedOperationException("Attempt to divide by zero");
        }
        int absDividend = Math.abs(number1);
        int absDivider = Math.abs(number2);
        int count = 0;
        while (absDividend >= absDivider) {
            absDividend = absDividend - absDivider;
            count++;
        }
        return checkSign(number1, number2, count);
    }


}

package ua.com.foxminded.division.maths;

public class Multiply extends Calculation {

    public int calculate(int number1, int number2) {
        int multiplier1 = Math.abs(number1);
        int multiplier2 = Math.abs(number2);
        if (multiplier1 < multiplier2) {
            multiplier1 = multiplier1 ^ multiplier2;
            multiplier2 = multiplier1 ^ multiplier2;
            multiplier1 = multiplier1 ^ multiplier2;
        }
        long count = 0;
       for (int i = 0; i < multiplier2; i++) {
           count = count + multiplier1;
       }
       int result = checkInteger(count);
        return checkSign(number1, number2, result);
    }

    private int checkInteger(long value) {
        if (value > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Result is not in integer range");
        }
        return (int) value;
    }

}

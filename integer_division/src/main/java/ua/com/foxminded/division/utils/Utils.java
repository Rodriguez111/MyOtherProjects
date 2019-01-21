package ua.com.foxminded.division.utils;

public class Utils {
   public static int[] getDigits(int number) {
        int numberOfDigits = digitsAmount(number);
        int[] digits = new int[numberOfDigits];
        int count = 0;
        while (number > 0) {
            digits[count] = number % 10;
            number = number / 10;
            count++;
        }
        return  reverseArray(digits);
    }

    /**
     *
     * @param array
     * @return
     */
    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static int digitsAmount(int number) {
        return String.valueOf(number).length();
    }

    public static void inputValidate(int number1, int number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        if (number1 < number2) {
            throw new UnsupportedOperationException("Dividend can not be less then divider!");
        }

    }

}

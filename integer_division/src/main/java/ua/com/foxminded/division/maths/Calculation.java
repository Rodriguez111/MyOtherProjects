package ua.com.foxminded.division.maths;

public abstract class Calculation {
    abstract int calculate(int number1, int number2);

int checkSign(int number1, int number2, int result) {
    if ((number1 < 0 && number2 >= 0) || (number2 < 0 && number1 >= 0)) {
        result = -result;
    }
    return result;
}


}

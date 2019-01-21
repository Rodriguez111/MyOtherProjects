package ua.com.foxminded.division.maths;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    private Calculation divide = new Divide();

    @Test
    public void shouldReturn0When2DividedBy5(){
        int actual = divide.calculate(2, 5);
        int expected= 0;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturn4When9DividedBy2(){
        int actual = divide.calculate(9, 2);
        int expected= 4;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldThrowsExceptionWhen2DividedBy0(){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            divide.calculate(2, 0);
        });
        assertEquals("Attempt to divide by zero", exception.getMessage());
    }

    @Test
    public void shouldReturn0When0DividedBy2(){
        int actual = divide.calculate(0, 2);
        int expected= 0;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnMines5WhenMines10DividedBy2(){
        int actual = divide.calculate(-10, 2);
        int expected= -5;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnMines5When10DividedByMines2(){
        int actual = divide.calculate(10, -2);
        int expected= -5;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturn5WhenMines10DividedByMines2(){
        int actual = divide.calculate(-10, -2);
        int expected= 5;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturn0When2DividedBy10(){
        int actual = divide.calculate(2, 10);
        int expected= 0;
        assertThat(actual, is(expected));
    }

}
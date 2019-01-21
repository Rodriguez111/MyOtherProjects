package ua.com.foxminded.division.maths;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MultiplyTest {
    private Multiply multiply = new Multiply();
    @Test
    public void shouldReturn10When2x5(){
       int actual = multiply.calculate(2, 5);
        int expected= 10;
        assertThat(actual, is(expected));
    }
    @Test
    public void shouldReturnMines10WhenMines2x5(){
        int actual = multiply.calculate(-2, 5);
        int expected= -10;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturn0When0x5(){
        int actual = multiply.calculate(0, 5);
        int expected= 0;
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldThrowsExceptionWhen99999x99999(){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            multiply.calculate(99999, 99999);
        });
        assertEquals("Result is not in integer range", exception.getMessage());
    }

}

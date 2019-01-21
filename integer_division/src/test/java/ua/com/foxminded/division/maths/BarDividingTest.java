package ua.com.foxminded.division.maths;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BarDividingTest {
    BarDividing barDividing = new BarDividing();

    @Test
    void shouldReturn3StepsWhen785DivideBy4() {
      List<Step> actual =  barDividing.calculate(785, 4);
        List<Step> expected = new ArrayList<>();
        Step step1 = new Step(785, 4, 3, 4, 196, 0, 0, 0, "");
        Step step2 = new Step(38, 36, 2, 0, 0, 0, 0, 0, "");
        Step step3 = new Step(25, 24, 1, 0, 0, 1, 1, 2, "");
        expected.add(step1);
        expected.add(step2);
        expected.add(step3);
        assertThat(actual, is(expected));
    }

    @Test
    void shouldReturn1StepWhen10DivideBy2() {
        List<Step> actual =  barDividing.calculate(10, 2);
        List<Step> expected = new ArrayList<>();
        Step step1 = new Step(10, 10, 0, 2, 5, 0, 0, 1, "");
        expected.add(step1);
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldThrowsExceptionWhen2DividedBy0(){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            barDividing.calculate(2, 0);
        });
        assertEquals("Attempt to divide by zero", exception.getMessage());
    }

    @Test
    public void shouldThrowsExceptionWhen2DividedBy10(){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            barDividing.calculate(2, 10);
        });
        assertEquals("Dividend can not be less then divider!", exception.getMessage());
    }
}
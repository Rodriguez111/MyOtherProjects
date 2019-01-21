package ua.com.foxminded.division.formatting;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.maths.BarDividing;
import ua.com.foxminded.division.maths.Step;
import ua.com.foxminded.division.output.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BelgiumFormatTest {
   private Format belgiumFormat = new BelgiumFormat(new ConsoleOutput());
   private BarDividing barDividing = new BarDividing();
   private String lineSeparator = System.lineSeparator();

    @Test
    void shouldFormatFirstStep() {
     List<Step> listOfSteps = barDividing.calculate(2548, 4);
     belgiumFormat.formatFirstStep(listOfSteps);

     Step expected =
       new Step(2548, 24, 1, 4, 637, 0, 0, 0, "_2548|4" + lineSeparator +
               " 24  |---" + lineSeparator +
               " --  |637" + lineSeparator);
       Step actual = listOfSteps.get(0);
        assertThat(actual, is(expected));
    }

    @Test
    void shouldFormatOtherSteps() {
        List<Step> listOfSteps = barDividing.calculate(2548, 4);
        belgiumFormat.formatOtherSteps(listOfSteps);
        List<Step>  expected = new ArrayList<>();
        Step step1 = new Step(2548, 24, 1, 4, 637, 0, 0, 0, "");
        Step step2 = new Step(14, 12, 2, 0, 0, 1, 1, 0, "_14" + lineSeparator
                + " 12" + lineSeparator + " --" + lineSeparator);
        Step step3 = new Step(28, 28, 0, 0, 0, 2, 2, 3, " _28" + lineSeparator
                + "  28" + lineSeparator + "  --" + lineSeparator + "   0" + lineSeparator);
        expected.add(step1);
        expected.add(step2);
        expected.add(step3);
        List<Step>  actual = listOfSteps;
        assertThat(actual, is(expected));
    }

    @Test
    void shouldFormatStep() {
       Step actual = new Step(28, 28, 0, 0, 0, 2, 2, 3, "");
       belgiumFormat.formatReminder(actual);
       Step expected = new Step(28, 28, 0, 0, 0, 2, 2, 3, "   0" + lineSeparator);
        assertThat(actual, is(expected));
    }
}
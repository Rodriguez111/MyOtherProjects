package ua.com.foxminded.division.maths;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class StepTest {


    @Test
    void shouldGetAbsdefWhenSetDefToAbc() {
      Step step = new Step(1, 1, 1);
      step.setPrintStep("abc");
      step.setPrintStep("def");
      String actual = step.getPrintStep();
      String expected = "abcdef";
      assertThat(actual, is(expected));

    }
}
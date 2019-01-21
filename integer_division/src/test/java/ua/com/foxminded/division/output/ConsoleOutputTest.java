package ua.com.foxminded.division.output;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.division.maths.Step;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConsoleOutputTest {


    private Output output = new ConsoleOutput();

    private PrintStream original;
    private PrintStream newPrintStream;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private String lineSeparator = System.lineSeparator();



    @BeforeEach
    public void saveDefaultStream() {
        this.original = System.out;
        newPrintStream = new PrintStream(baos);
        System.setOut(newPrintStream);
    }

    @AfterEach
    public void returnDefaultStream() {
        System.setOut(original);
    }

    @Test
    void shouldOutputThreeLinesWhenThreeElementsInList() {
        Step step1 = new Step();
        Step step2 = new Step();
        Step step3 = new Step();
        step1.setPrintStep("  125\r\n");
        step2.setPrintStep("  98   \r\n");
        step3.setPrintStep("  ---|\r\n");
        List<Step> list = List.of(step1, step2, step3);
        output.outputResult(list);
        String actual = baos.toString();

        StringBuilder sb = new StringBuilder();
        sb.append("  125")
                .append(lineSeparator)
                .append("  98   ")
                .append(lineSeparator)
                .append("  ---|")
                .append(lineSeparator);
        String expected = sb.toString();
        assertThat(actual, is(expected));
    }
}
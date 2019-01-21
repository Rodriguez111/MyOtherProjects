package ua.com.foxminded.division.output;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.maths.Step;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JsonOutputTest {
    JsonOutput jsonOutput = new JsonOutput();

    @Test
    void shouldReturnDeSerializedFromJSON() throws IllegalAccessException, NoSuchFieldException {
        List<Step> expected = new ArrayList<>();
        Step step1 = new Step(785, 4, 3, 4, 196, 0, 0, 0, "");
        Step step2 = new Step(38, 36, 2, 0, 0, 0, 0, 0, "");
        Step step3 = new Step(25, 24, 1, 0, 0, 1, 1, 2, "");
        expected.add(step1);
        expected.add(step2);
        expected.add(step3);
        jsonOutput.outputResult(expected);

        Field field = JsonOutput.class.getDeclaredField("file");
        field.setAccessible(true);
        File file = (File)field.get(jsonOutput);
        List<Step> actual = deserialize(file);
        assertThat(actual, is(expected));
    }

    private List<Step> deserialize(File file) {
        List<Step> listOfSteps = new ArrayList<>();
        String jsonString = "";
        Type typeToken = new TypeToken<Step>() {}.getType();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader inStream = new BufferedReader(fileReader);
           while ((jsonString = inStream.readLine()) != null) {
               Step step = new Gson().fromJson(jsonString, typeToken);
               listOfSteps.add(step);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfSteps;
    }
}
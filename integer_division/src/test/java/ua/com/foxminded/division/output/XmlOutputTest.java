package ua.com.foxminded.division.output;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.maths.Step;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class XmlOutputTest {
    Output output = new XmlOutput();

    @Test
    void shouldReturnDeSerializedFromXML() throws IllegalAccessException, NoSuchFieldException, IOException {
        List<Step> expected = new ArrayList<>();
        Step step1 = new Step(785, 4, 3, 4, 196, 0, 0, 0, "");
        Step step2 = new Step(38, 36, 2, 0, 0, 0, 0, 0, "");
        Step step3 = new Step(25, 24, 1, 0, 0, 1, 1, 2, "");
        expected.add(step1);
        expected.add(step2);
        expected.add(step3);
        output.outputResult(expected);
        Field field = XmlOutput.class.getDeclaredField("file");
        field.setAccessible(true);
        File file = (File)field.get(output);

        List<Step> actual = deserialize(file);
        assertThat(actual, is(expected));

        try {
            deserialize(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Step> deserialize(File file) throws IOException {
        List<Step> listOfSteps = new ArrayList<>();
        XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(file));
        try {
            while (true) {
               listOfSteps.add((Step) xmlDecoder.readObject());
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        xmlDecoder.close();
        return listOfSteps;
    }
}
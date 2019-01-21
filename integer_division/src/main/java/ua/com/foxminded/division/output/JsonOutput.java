package ua.com.foxminded.division.output;

import com.google.gson.Gson;
import ua.com.foxminded.division.maths.Step;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonOutput implements Output {

    private Gson json = new Gson();
    private String lineSeparator = System.lineSeparator();
    private File file = new File("dividing.json");

    @Override
    public void outputResult(List<Step> listOfSteps) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Step eachStep : listOfSteps) {
                String result = json.toJson(eachStep) + lineSeparator;
                fileWriter.write(result);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ua.com.foxminded.division.output;

import ua.com.foxminded.division.maths.Step;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XmlOutput implements Output {

   private File file = new File("dividing.xml");

    @Override
    public void outputResult(List<Step> listOfSteps) {
        XMLEncoder xmlEncoder = null;
        try {
            xmlEncoder = new XMLEncoder(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Step eachStep : listOfSteps) {
            xmlEncoder.writeObject(eachStep);
        }
        xmlEncoder.close();


    }
}

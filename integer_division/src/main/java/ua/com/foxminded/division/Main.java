package ua.com.foxminded.division;

import ua.com.foxminded.division.formatting.BelgiumFormat;
import ua.com.foxminded.division.formatting.BritishFormat;
import ua.com.foxminded.division.formatting.Format;
import ua.com.foxminded.division.output.ConsoleOutput;
import ua.com.foxminded.division.output.JsonOutput;
import ua.com.foxminded.division.output.XmlOutput;

public class Main {
    public static void main(String[] args) {



       //BarDividing barDividing = new BarDividing();
       //List<Step> result = barDividing.calculate(2004000000, 20);
       // List<Step> result = barDividing.calculate(78945, 4);
       // List<Step> result = barDividing.calculate(20, 20);
        //List<Step> result = barDividing.calculate(78945, 78);
       // List<Step> result = barDividing.calculate(2004000019, 20);
        //List<Step> result = barDividing.calculate(2004000200, 20);
        //List<Step> result = barDividing.calculate(2001, 2);


        //BelgiumFormat belgiumFormat = new BelgiumFormat(new ConsoleOutput());
        //Format format = new BelgiumFormat(new XmlOutput());
        Format format = new BritishFormat(new ConsoleOutput());

        //Format format = new BelgiumFormat(new ConsoleOutput());

        //format.formatResult(78954, 21);
        //format.formatResult(2004000000, 20);
        //format.formatResult(10, -1);
        //format.formatResult(125487, 811);
        //format.formatResult(78500, 4);
       format.formatResult(2548, 24);









    }
}

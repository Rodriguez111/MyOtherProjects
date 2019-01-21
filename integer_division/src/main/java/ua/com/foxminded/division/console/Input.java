package ua.com.foxminded.division.console;

import ua.com.foxminded.division.exceptions.WrongArgumentException;
import ua.com.foxminded.division.formatting.BelgiumFormat;
import ua.com.foxminded.division.formatting.BritishFormat;
import ua.com.foxminded.division.formatting.Format;
import ua.com.foxminded.division.output.ConsoleOutput;

import org.apache.commons.cli.*;
import ua.com.foxminded.division.output.JsonOutput;
import ua.com.foxminded.division.output.Output;
import ua.com.foxminded.division.output.XmlOutput;

public class Input {

    public static void main(String[] args) {
        Output output = null;
        Format format = null;

        CommandLineParser parser = new DefaultParser();
        CommandLine line;

        if (args.length != 4) {
            System.out.print("You must enter four arguments:\r\n"
                  + "1. dividend (integer value)\r\n"
                  + "2. divider (integer value)\r\n"
                  + "3. output format:\r\n"
                  + "    -c console output\r\n"
                  + "    -j JSON file output\r\n"
                  + "    -x XML file output\r\n"
                  + "4. division format:\r\n"
                  + "    -b Belgium format\r\n"
                  + "    -u United Kingdom format\r\n"
            );
            System.exit(0);
        }




        if (args[2].equals("-c")) {
            output = new ConsoleOutput();
        } else if (args[2].equals("-j")) {
            output = new JsonOutput();
        } else if (args[2].equals("-x")) {
            output = new XmlOutput();
        } else {
            throw new WrongArgumentException("Third argument for output format is not correct");
        }

        if (args[3].equals("-b")) {
            format = new BelgiumFormat(output);
        } else if (args[3].equals("-u")) {
            format = new BritishFormat(output);
        } else {
            throw new WrongArgumentException("Fourth argument for division format is not correct");
        }






//        Options options = new Options();
//        Option option1 = new Option("o", "output", true, "Choose output format");
//        Option option2 = new Option("f", "format", true, "Choose format for console output");
//        option1.setRequired(true);
//        option2.setRequired(true);
//        options.addOption(option1);
//        options.addOption(option2);
//
//        try {
//            line = parser.parse(options, args);
//
//            if (line.hasOption("o")) {
//                if (line.getOptionValue("o").equals("-c")) {
//                    System.out.println("Option c argument " + "(Console format)");
//                    output = new ConsoleOutput();
//                }
//                if (line.getOptionValue("o").equals("-j")) {
//                    System.out.println("Option j argument " + "(JSON format)");
//                    output = new JsonOutput();
//                }
//                if (line.getOptionValue("o").equals("-x")) {
//                    System.out.println("Option x argument " + "(XML format)");
//                    output = new XmlOutput();
//                }
//
//            }
//
//
//            if (line.hasOption("f")) {
//              if (line.getOptionValue("f").equals("--b")) {
//                  System.out.println("Option f argument "   + "(Belgium)");
//                  format = new BelgiumFormat(output);
//
//              }
//              if (line.getOptionValue("f").equals("--u")) {
//                    System.out.println("Option f argument " + "(Great Britain)");
//                  format = new BritishFormat(output);
//                }
//
//            }
//
//
//
//        } catch (MissingOptionException e) {
//            System.out.println(e.getMessage());
//        } catch (MissingArgumentException e) {
//            System.out.println(e.getMessage() + ". You must define argument for this option");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }





        int dividend = checkValue(args[0]);
        int divider = checkValue(args[1]);



          format.formatResult(dividend, divider);

    }


    static int checkValue(String argument) {
        int result = 0;
        try {
            result = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new WrongArgumentException("This is not an integer value");
        }
        return result;
    }






}

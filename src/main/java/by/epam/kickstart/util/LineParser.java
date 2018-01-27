package by.epam.kickstart.util;


public class LineParser {

    public static final String COORDINATES_PARSER_INDICATOR = " ";
    public static final String DATA_PARSER_INDICATOR = "!";

    public static String[] parseLine(String data, String parserIndicator) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data is empty.");
        }
        if (parserIndicator == null || parserIndicator.isEmpty()) {
            throw new IllegalArgumentException("Indicator is empty.");
        }

        String[] arguments = data.split(parserIndicator);

        if (arguments.length == 1) {
            throw new IllegalArgumentException("Data wasn't parsed.");
        }

        return arguments;

    }

}

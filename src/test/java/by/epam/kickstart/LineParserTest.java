package by.epam.kickstart;

import by.epam.kickstart.util.LineParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LineParserTest {

    private static String validData;
    private static String[] parsedValidData;

    @BeforeClass
    public static void setUpTestingObjects() {
        validData = "1.1 2.2 3.3";
        parsedValidData = new String[]{"1.1", "2.2", "3.3"};
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullDataCauseException() {
        String notValid = null;

        LineParser.parseLine(notValid, LineParser.DATA_PARSER_INDICATOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullParserIndcatorCauseException() {
        String notValidParserIndicator = null;

        LineParser.parseLine(validData, notValidParserIndicator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyDataCauseException() {
        String notValid = null;

        LineParser.parseLine(notValid, LineParser.DATA_PARSER_INDICATOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyParserIndicatorCauseException() {
        String notValidParserIndicator = "";

        LineParser.parseLine(validData, notValidParserIndicator);
    }

    @Test
    public void shouldLineBeParsedSuccessful() {
        String[] currentData = LineParser.parseLine(validData, LineParser.COORDINATES_PARSER_INDICATOR);

        Assert.assertArrayEquals(parsedValidData, currentData);
    }


}

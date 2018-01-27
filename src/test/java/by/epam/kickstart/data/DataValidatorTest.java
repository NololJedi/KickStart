package by.epam.kickstart.data;

import by.epam.kickstart.util.data.DataValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataValidatorTest {

    private static DataValidator dataValidator;
    private static String[] validCoordinates;

    @BeforeClass
    public static void setUpTestingObject() {
        dataValidator = new DataValidator();
        validCoordinates = new String[]{"2.2", "2.2", "2.2"};
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullDataCauseException() {
        String[] parsedData = null;

        dataValidator.checkCoordinatesForUniqueness(parsedData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEmptyDataCauseException() {
        String[] parsedData = {};

        dataValidator.checkCoordinatesForUniqueness(parsedData);
    }

    @Test
    public void shouldCoordinatesSyntaxBeValid() {
        Assert.assertTrue(dataValidator.checkArguments(validCoordinates));
    }

    @Test
    public void shouldCoordinatesSyntaxBeNotValidByLostArgument() {
        String[] notValidCoordinates = {"2.2", "2.2", ".2"};

        Assert.assertFalse(dataValidator.checkArguments(notValidCoordinates));
    }

    @Test
    public void shouldCoordinatesSyntaxBeNotValidByIllegalLiteral() {
        String[] notValidCoordinates = {"2.2", "2.2", "2x.2"};

        Assert.assertFalse(dataValidator.checkArguments(notValidCoordinates));
    }

    @Test
    public void shouldCoordinatesCountOfArgumentsBeValid() {
        Assert.assertTrue(dataValidator.checkArguments(validCoordinates));
    }

    @Test
    public void shouldCoordinatesCountOfArgumentsBeNotValid() {
        String[] validCoordinates = {"2.2", "2.2"};

        Assert.assertFalse(dataValidator.checkArguments(validCoordinates));
    }

    @Test
    public void shouldDataHaveSimilarCoordinates() {
        String[] data = {"2.2 1.1 1.1","2.2 1.1 1.1","0.0 0.0 0.0","3.2 2.2 2.2"};

        Assert.assertFalse(dataValidator.checkCoordinatesForUniqueness(data));
    }

    @Test
    public void shouldDataHaveNotSimilarCoordinates() {
        String[] data ={"2.2 1.1 2.1","2.2 1.1 1.1","0.0 0.0 0.0","3.2 2.2 2.2"};

        Assert.assertTrue(dataValidator.checkCoordinatesForUniqueness(data));
    }

}

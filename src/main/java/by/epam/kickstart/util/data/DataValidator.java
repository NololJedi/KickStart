package by.epam.kickstart.util.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private static final String PATTERN_OF_COORDINATE_VALIDATION = "^-?\\d+\\.[0-9]$";
    private static final int COUNT_OF_COORDINATES_ARGUMENTS = 3;

    private boolean checkArgumentsSyntax(String[] parsedCoordinates) {
        boolean isValid = true;
        Pattern pattern = Pattern.compile(PATTERN_OF_COORDINATE_VALIDATION);

        for (int arrayIndex = 0; arrayIndex < parsedCoordinates.length; arrayIndex++) {
            Matcher matcher = pattern.matcher(parsedCoordinates[arrayIndex]);
            if (!matcher.matches()) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private boolean checkArgumentsCount(String[] parsedCoordinates) {
        int currentCountOfArguments = parsedCoordinates.length;

        return currentCountOfArguments == COUNT_OF_COORDINATES_ARGUMENTS;
    }

    public boolean checkArguments(String[] parsedCoordinates) {
        if (parsedCoordinates == null || parsedCoordinates.length == 0) {
            throw new IllegalArgumentException("Coordinates is empty.");
        }

        boolean isSyntaxValid = false;
        boolean isArgumentsCountValid = false;

        if (checkArgumentsSyntax(parsedCoordinates)) {
            isSyntaxValid = true;
        }
        if (checkArgumentsCount(parsedCoordinates)) {
            isArgumentsCountValid = true;
        }

        return isArgumentsCountValid && isSyntaxValid;
    }

    public boolean checkCoordinatesForUniqueness(String[] parsedData) {
        if (parsedData == null || parsedData.length == 0) {
            throw new IllegalArgumentException("Coordinates not found.");
        }

        boolean isValid = true;

        for (int arrayIndex = 0; arrayIndex < parsedData.length - 1; arrayIndex++) {
            String currentCoordinates = parsedData[arrayIndex];
            for (int innerArrayIndex = arrayIndex + 1; innerArrayIndex < parsedData.length; innerArrayIndex++) {
                String checkingCoordinates = parsedData[innerArrayIndex];
                if (currentCoordinates.equals(checkingCoordinates)) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid;
    }

}

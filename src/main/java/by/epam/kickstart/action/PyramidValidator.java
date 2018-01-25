package by.epam.kickstart.action;

import by.epam.kickstart.entities.Pyramid;

public class PyramidValidator {

    private static final int MINIMAL_COUNT_OF_POINTS = 4;

    public boolean isFigureRegularPyramid(Pyramid pyramid) {

        if (pyramid.getPoints().size() < MINIMAL_COUNT_OF_POINTS) {
            return false;
        }
        return true;
    }

}

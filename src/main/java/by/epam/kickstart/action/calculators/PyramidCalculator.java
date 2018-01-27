package by.epam.kickstart.action.calculators;

import by.epam.kickstart.action.RegularPyramidParameters;
import by.epam.kickstart.entities.Point;
import by.epam.kickstart.entities.Pyramid;
import by.epam.kickstart.util.creators.PyramidCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class PyramidCalculator {

    public double calculateVolume(Pyramid pyramid) {
        double baseArea = calculateBaseArea(pyramid);
        double apexHeight = calculateApexHeight(pyramid);
        double pyramidVolume = (baseArea * apexHeight) / 3;

        return pyramidVolume;
    }

    public double calculateArea(Pyramid pyramid) {
        double pyramidBaseArea = calculateBaseArea(pyramid);
        double pyramidSideSurfaceArea = calculateSideSurfaceArea(pyramid);
        double pyramidArea = pyramidBaseArea + pyramidSideSurfaceArea;

        return pyramidArea;
    }

    public double calculateBaseArea(Pyramid pyramid) {
        List<Vector3D> baseVectors = getParameters(pyramid).getBaseVectors();
        int countOfBaseAngles = baseVectors.size();
        double baseSideLength = getParameters(pyramid).getBaseSideLength();
        double baseArea = (countOfBaseAngles * Math.pow(baseSideLength, 2)) / 4 * Math.tan(Math.PI / countOfBaseAngles);

        return baseArea;
    }

    public double calculateSideSurfaceArea(Pyramid pyramid) {
        List<Vector3D> baseVectors = getParameters(pyramid).getBaseVectors();
        int countOfEdges = baseVectors.size();
        double edgeArea = calculateEdgeArea(pyramid);
        double sideSurfaceArea = countOfEdges * edgeArea;

        return sideSurfaceArea;
    }

    public double calculateEdgeArea(Pyramid pyramid) {
        double perimeter = 2 * getParameters(pyramid).getEdgeSideLength() + getParameters(pyramid).getBaseSideLength();
        double halfPerimeter = perimeter / 2;
        double edgeArea = Math.sqrt(halfPerimeter * Math.pow((halfPerimeter - getParameters(pyramid).getEdgeSideLength()), 2)
                * (halfPerimeter - getParameters(pyramid).getBaseSideLength()));

        return edgeArea;
    }

    public double calculateApexHeight(Pyramid pyramid) {
        List<Vector3D> baseVectors = getParameters(pyramid).getBaseVectors();
        int countOfAngles = baseVectors.size();
        double edgeSideLength = getParameters(pyramid).getEdgeSideLength();
        double radius = edgeSideLength / (2 * Math.sin(180 / countOfAngles));
        double apexHeight = Math.sqrt(Math.pow(edgeSideLength, 2) - Math.pow(radius, 2));

        return apexHeight;
    }

    public String calculateVolumeRatioCutPyramid(Pyramid pyramid, List<Point> coordinatePlane) {
        int pointsCount = 4;
        if (coordinatePlane == null || coordinatePlane.size() != pointsCount) {
            throw new IllegalArgumentException("Empty coordinate plane.");
        }
        Point apex = getParameters(pyramid).getApex();
        List<Point> pointsOfNewPyramid = new ArrayList<>(coordinatePlane);
        pointsOfNewPyramid.add(apex);

        Pyramid littlePyramid = PyramidCreator.createPyramid(pointsOfNewPyramid);
        double littlePyramidVolume = calculateVolume(littlePyramid);
        double currentPyramidVolume = calculateVolume(pyramid);
        double cutPyramidVolume = currentPyramidVolume - littlePyramidVolume;

        double ratio = 0;
        if (littlePyramidVolume > cutPyramidVolume) {
            ratio = littlePyramidVolume / cutPyramidVolume;
        }
        if (cutPyramidVolume > littlePyramidVolume) {
            ratio = cutPyramidVolume / littlePyramidVolume;
        }
        if (cutPyramidVolume == littlePyramidVolume) {
            ratio = 1;
        }

        String result = String.format("Ratio after cutting = 1 : %f", ratio);

        return result;
    }

    private RegularPyramidParameters getParameters(Pyramid pyramid) {
        RegularPyramidParameters regularPyramidParameters = RegularPyramidParameters.getInstance(pyramid);

        return regularPyramidParameters;
    }

}

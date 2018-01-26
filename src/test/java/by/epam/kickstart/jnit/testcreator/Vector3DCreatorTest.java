package by.epam.kickstart.jnit.testcreator;

import by.epam.kickstart.entities.Point;
import by.epam.kickstart.util.creators.Vector3DCreator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector3DCreatorTest {

    private static Vector3D validVector;

    @BeforeClass
    public static void setValidVector() {

        validVector = new Vector3D(-2.0, 6.0,-2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullPointsCauseException() {
        Point notValidPoint = null;
        Point point = new Point(-1.0,4.0,0.0);

        Vector3D vector3D = Vector3DCreator.createVector(notValidPoint,point);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSimilarPointsCauseException() {
        Point notValidPoint =new Point(-1.0,4.0,0.0);
        Point point = new Point(-1.0,4.0,0.0);

        Vector3D vector3D = Vector3DCreator.createVector(notValidPoint,point);
    }

    @Test
    public void shouldVectorCreatingBeSuccessful() {
        Point start = new Point(1.0, -2.0, 2.0);
        Point end = new Point(-1.0,4.0,0.0);

        Assert.assertEquals(validVector,Vector3DCreator.createVector(start, end));
    }

}

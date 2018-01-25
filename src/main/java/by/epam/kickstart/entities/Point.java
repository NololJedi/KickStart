package by.epam.kickstart.entities;

public class Point {

    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }

        Point point = (Point) object;

        if (xCoordinate != point.xCoordinate) {
            return false;
        }
        if (yCoordinate != point.yCoordinate) {
            return false;
        }
        if (zCoordinate != point.zCoordinate){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * (xCoordinate + yCoordinate + zCoordinate));
    }

    @Override
    public String toString() {
        return String.format("Point : X = %.1f, Y = %.1f, Z = %.1f;",xCoordinate, yCoordinate, zCoordinate);
    }
}


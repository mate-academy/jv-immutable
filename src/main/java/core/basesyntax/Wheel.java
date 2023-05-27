package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (wheel == null || getClass() != wheel.getClass()) {
            return false;
        }
        Wheel current = (Wheel) wheel;
        return this.radius == current.radius;
    }

    public int hashCode() {
        int reslt = 17;
        reslt = reslt * 31 + radius;
        return reslt;
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

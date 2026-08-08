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

    @Override
    public boolean equals(Object wheel) {
        if (wheel == null) {
            return false;
        }
        if (this == wheel) {
            return true;
        }
        if (!this.getClass().equals(wheel.getClass())) {
            return false;
        }
        Wheel current = (Wheel) wheel;
        return radius == current.getRadius();
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public int hashCode() {
        return 31 + radius;
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

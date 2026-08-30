package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class
    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Wheel wheel)) {
            return false;
        }
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public Wheel clone() {
        try {
            Wheel clone = (Wheel) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

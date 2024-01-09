package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class
    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return wheel.radius == this.radius;
    }

    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot clone Wheel class ", e);
        }
    }
}

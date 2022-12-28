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

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) object;
        return getRadius() == wheel.getRadius();
    }

    public int hashCode() {
        return Objects.hash(getRadius());
    }

    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone for Wheel object", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

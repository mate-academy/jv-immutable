package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) object;
        return radius == wheel.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}

package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel)) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return Objects.equals(radius, wheel.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    protected Wheel clone() {
        try {
            Wheel wheel = (Wheel) super.clone();
            return wheel;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create wheel clone", e);
        }
    }
}

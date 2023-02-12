package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int i) {
        this.radius = i;
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

    @Override
    public Wheel clone() {
        try {
            Wheel wheel = (Wheel) super.clone();
            wheel.setRadius(radius);
            return wheel;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Wheel", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return this.radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

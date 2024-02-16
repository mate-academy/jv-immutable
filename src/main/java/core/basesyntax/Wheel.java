package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(Wheel original) {
        this.radius = original.radius;
    }

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel wheel)) {
            return false;
        }
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        Wheel wheel = null;
        try {
            wheel = (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        wheel.radius = this.radius;
        return wheel;

    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

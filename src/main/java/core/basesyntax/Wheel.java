package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Wheel(int radius) {
        this.radius = radius;
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public Wheel clone() {
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Problems when cloning Wheel object", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel wheel)) {
            return false;
        }
        return getRadius() == wheel.getRadius();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}

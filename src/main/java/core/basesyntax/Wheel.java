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

    public void setRadius(int newRadius) {
        this.radius = newRadius;
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
            Wheel clone = (Wheel) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(Wheel.class)) {
            return radius == ((Wheel) obj).getRadius();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

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
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone Wheel instance", e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object object) {
        return object == this
                || (
                        object != null
                        && object.getClass() == Wheel.class
                        && ((Wheel) object).radius == radius
                );
    }
}

package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (wheel == null) {
            return false;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) wheel;
            return this.radius == current.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cann't create clone of Wheel", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

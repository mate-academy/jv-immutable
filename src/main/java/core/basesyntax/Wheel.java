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
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone for Wheel object", e);
        }
    }

    @Override
    public boolean equals(Object newRadius) {
        if (this == newRadius) {
            return true;
        }
        if (newRadius == null || getClass() != newRadius.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) newRadius;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

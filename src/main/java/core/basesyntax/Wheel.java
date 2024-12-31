package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel wheel) {
        if (wheel == null) {
            throw new IllegalArgumentException("Wheel cannot be null");
        }
        this.radius = wheel.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported for Wheel", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "radius=" + radius +
                '}';
    }
}

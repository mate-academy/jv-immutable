package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private int radius;

    public Wheel (int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    @Override
    public Wheel clone() {
        return new Wheel(this.getRadius());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Wheel wheel = (Wheel) object;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

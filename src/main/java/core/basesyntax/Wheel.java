package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        } else {
            Wheel wheel = (Wheel) object;
            return radius == wheel.radius;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

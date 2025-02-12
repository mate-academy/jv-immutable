package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private final int radius;

    //implement this class
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

    @Override
    public int hashCode() {
        return Objects.hash(radius);
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
        return Objects.equals(radius, wheel.radius);
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }
}

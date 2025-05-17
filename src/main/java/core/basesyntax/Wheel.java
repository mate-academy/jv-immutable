package core.basesyntax;

import java.util.Objects;

public final class Wheel {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        {
            if (!(o instanceof Wheel wheel)) return false;
            return radius == wheel.radius;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

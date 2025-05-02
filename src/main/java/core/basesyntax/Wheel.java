package core.basesyntax;

import java.util.Objects;

public record Wheel(int radius)  {
    public Wheel {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius is have >0");
        }
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel wheel)) {
            return false;
        }
        return this.radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

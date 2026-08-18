package core.basesyntax;

import java.util.Objects;

public class Wheel {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return  radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Wheel other = (Wheel) obj;
        return radius == other.radius;
    }

}

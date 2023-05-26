package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = Integer.valueOf(radius);
    }

    public int getRadius() {
        return Integer.valueOf(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return getRadius() == wheel.getRadius();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }

    public void setRadius(int i) {
    }

    @Override
    protected Wheel clone()  {
        return new Wheel(radius);
    }
}

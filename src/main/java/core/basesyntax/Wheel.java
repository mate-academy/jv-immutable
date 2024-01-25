package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private final int radius;
    //implement this class

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel setRadius(int radius) {
        Wheel newWheel = new Wheel(radius);
        return newWheel;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Wheel not cloned", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Wheel.class != o.getClass()) return false;
        Wheel current = (Wheel) o;
        return radius == current.radius;
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

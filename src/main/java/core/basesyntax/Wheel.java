package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
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

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Wheel", e);
        }
    }

    public int getRadius() {
        return radius;
    }

    public Wheel setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null ? this.radius == ((Wheel) obj).radius : false;
    }
}

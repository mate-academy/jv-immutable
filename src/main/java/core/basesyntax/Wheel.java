package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private int radius;

    //implement this class

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Wheel)
                && (Objects.equals(((Wheel) obj).radius, radius));
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant clone object of Wheel", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

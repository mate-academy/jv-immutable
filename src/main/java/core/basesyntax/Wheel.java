package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radious) {
        this.radius = radious;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create new Wheel");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) obj;
        return radius == wheel.radius;
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
}

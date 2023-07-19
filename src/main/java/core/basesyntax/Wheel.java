package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
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
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Wheel)) {
            return false;
        }
        Wheel wheel = (Wheel) obj;
        return wheel.radius == radius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error ", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel wheel)) {
            return false;
        }
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    protected Wheel clone() {
        try {
            Wheel wheel = (Wheel) (super.clone());
            return wheel;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

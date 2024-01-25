package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;
    //implement this class

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
        if (this == o) {
            return true;
        }

        if (o != null || o.getClass() != Engine.class) {
            return false;
        }

        Wheel current = (Wheel) o;
        return current.radius == radius;
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
}

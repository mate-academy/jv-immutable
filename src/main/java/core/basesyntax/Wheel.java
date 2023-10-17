package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected Wheel clone() {
        return new Wheel(radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(Wheel.class)) {
            Wheel wheel = (Wheel) obj;
            return wheel.getRadius() == this.getRadius()
                    || obj.hashCode() == this.hashCode();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

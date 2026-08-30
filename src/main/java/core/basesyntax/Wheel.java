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

    public int getRadius() {
        return radius;
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
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(Wheel.class)) {
            return false;
        }
        return radius == ((Wheel) obj).radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    protected Wheel clone() {
        Wheel clondeWheel = null;
        try {
            clondeWheel = (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can`t cloned Wheel",e);
        }
        return clondeWheel;
    }
}

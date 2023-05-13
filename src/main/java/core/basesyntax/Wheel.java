package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

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
    public Wheel clone() {
        try {
            Wheel clone = (Wheel) super.clone();
            clone.radius = this.radius;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create copy of this object", e);
        }
    }

    @Override
    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (wheel == null) {
            return false;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) wheel;
            return this.radius == current.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

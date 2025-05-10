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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) object;
        return this.radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        int res = 29;
        res = 19 * res + radius;
        return res;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone this Wheel", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

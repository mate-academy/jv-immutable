package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    Wheel(int radius) {
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
        if (o != null && o.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) o;
            return this.radius == current.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31 * 17 + getRadius();
        return result;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone wheel.", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + getRadius()
            + '}';
    }
}

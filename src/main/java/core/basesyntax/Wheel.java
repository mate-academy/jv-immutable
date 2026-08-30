package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public int hashCode() {
        return radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null && obj == null) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) obj;
            return radius == current.radius;
        }
        return false;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Wheel object", e);
        }
    }
}

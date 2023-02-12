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
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Wheel)) {
            return false;
        }

        Wheel other = (Wheel) object;
        return radius == other.radius;
    }

    @Override
    public Wheel clone() {
        try {
            Wheel clone = (Wheel) super.clone();
            clone.radius = radius;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't clone Wheel object");
        }
    }
}

package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone the object!", e);
        }
    }

    public boolean equals(Object wheel) {
        if (wheel == this) {
            return true;
        }
        if (wheel == null) {
            return false;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) wheel;
            return this.getRadius() == current.getRadius();
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
    }
}

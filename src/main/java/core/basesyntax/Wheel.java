package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class
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
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
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
            return this.radius == current.radius;
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
    }

    @Override
    public Wheel clone() {
        try {
            Wheel clone = (Wheel) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of wheel object", e);
        }
    }
}

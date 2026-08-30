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
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
    }

    @Override
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

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone of Wheel object cannot be created", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

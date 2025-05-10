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

    public boolean equals(Object wheel) {
        if (wheel == null || wheel.getClass() != this.getClass()) {
            return false;
        }
        Wheel newWheel = (Wheel) wheel;
        if (this == newWheel) {
            return true;
        }
        return radius == newWheel.getRadius();
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode += hashCode * radius;
        return hashCode;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

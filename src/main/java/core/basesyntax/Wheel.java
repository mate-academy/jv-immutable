package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class

    public Wheel() {
    }

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
        return radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Wheel wheel = (Wheel) obj;
        return wheel.radius == this.radius;
    }

    @Override
    public Wheel clone() {
        try {
            Wheel clone = (Wheel) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Can't create clone of Wheel", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}

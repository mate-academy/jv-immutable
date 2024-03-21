package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

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
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
    }

    @Override
    public boolean equals(Object wheel) {
        if (wheel == null) {
            return false;
        }
        if (this == wheel) {
            return true;
        }
        if (!wheel.getClass().equals(Wheel.class)) {
            return false;
        }
        Wheel current = (Wheel) wheel;
        return radius == current.radius;
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }
}

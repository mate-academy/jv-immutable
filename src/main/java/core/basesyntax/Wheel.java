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
    public Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + radius;
        return result;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (object.getClass() == Wheel.class) {
            Wheel wheel = (Wheel) object;
            return this.radius == wheel.radius;
        }

        return false;
    }
}

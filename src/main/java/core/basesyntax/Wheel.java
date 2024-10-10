package core.basesyntax;

public class Wheel implements Cloneable {

    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    protected Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Wheel wheel = (Wheel) object;
        return getRadius() == wheel.getRadius();
    }

    @Override
    public int hashCode() {
        return getRadius();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

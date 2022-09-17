package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(final int radius) {
        this.radius = radius;
    }

    private Wheel(final Wheel wheel) {
        this.radius = wheel.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(final int newRadius) {
        this.radius = newRadius;
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Wheel wheel = (Wheel) o;

        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return radius;
    }

    @Override
    public Wheel clone() {
        Wheel clone;
        try {
            clone = (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone is not supported", e);
        }
        return new Wheel(clone);
    }
}

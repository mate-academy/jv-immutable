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
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Wheel(this.radius);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wheel wheel = (Wheel) o;

        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return radius;
    }
}

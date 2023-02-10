package core.basesyntax;

public final class Wheel implements Cloneable{
    private final int radius;

    //implement this class

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel setRadius(int radius) {
        return new Wheel(radius);
    }

    public Wheel clone() {
        return new Wheel(this.radius);
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

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

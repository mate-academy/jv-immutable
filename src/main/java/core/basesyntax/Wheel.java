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
    public Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == getClass()) {
            Wheel wheel = (Wheel) o;
            return radius == wheel.getRadius();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * radius;
    }
}

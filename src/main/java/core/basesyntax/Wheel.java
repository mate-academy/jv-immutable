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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || o.getClass() != Wheel.class) {
            return false;
        } else if (this.radius == ((Wheel) o).getRadius()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return radius * 17;
    }

    public Wheel clone() {
        return new Wheel(radius);
    }
}

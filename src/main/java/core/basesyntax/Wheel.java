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
    public int hashCode() {
        return 17 * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(Wheel.class)) {
            return false;
        }
        Wheel wheel = (Wheel)obj;
        return this.radius == wheel.getRadius();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Wheel clone() {
        Wheel wheel = new Wheel(radius);
        return wheel;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

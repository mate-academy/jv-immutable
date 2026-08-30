package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
    //implement this class

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
        int result = 5;
        result = result * radius;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Wheel current = (Wheel) obj;
        if (current == null) {
            return false;
        }
        return this.radius == current.radius;
    }
}

package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel wheel) {
        this.radius = wheel.getRadius();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Wheel wheel)) {
            return false;
        }

        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //implement this class
    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

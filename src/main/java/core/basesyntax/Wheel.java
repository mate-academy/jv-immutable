package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel wheel) {
        this.radius = wheel.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Wheel withRadius(int newRadius) {
        return new Wheel(newRadius); // Повертає новий об'єкт з новим радіусом
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wheel wheel) {
            return Objects.equals(radius, wheel.radius);
        }
        return false;
    }

    @Override
    protected Wheel clone() {
        return new Wheel(this);
    }
}

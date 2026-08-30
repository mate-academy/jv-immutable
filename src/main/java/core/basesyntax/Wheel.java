package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {

    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    //implement this class
    @Override
    public Wheel clone() {

        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t to clone new car!");
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return radius == ((Wheel) obj).radius;

    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

}

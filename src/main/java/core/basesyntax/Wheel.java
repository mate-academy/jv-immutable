package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create wheel clone", e);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Wheel newWheel = (Wheel) object;
        return newWheel.radius == radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

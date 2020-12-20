package core.basesyntax;

import java.util.Objects;

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
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone object Wheel", e);
        }
    }

    @Override
    public boolean equals(Object anotherWheel) {
        if (this == anotherWheel) {
            return true;
        }
        if (anotherWheel == null || getClass() != anotherWheel.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) anotherWheel;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

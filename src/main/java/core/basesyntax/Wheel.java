package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
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
            Wheel clonedWheel = (Wheel) super.clone();
            clonedWheel.radius = this.radius;
            return clonedWheel;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) obj;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

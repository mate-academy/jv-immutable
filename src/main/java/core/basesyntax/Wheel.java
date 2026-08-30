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
            throw new RuntimeException("Cloning failed", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel)) {
            return false;
        }
        Wheel other = (Wheel) o;
        return radius == other.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

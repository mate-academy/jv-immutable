package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (wheel == null || getClass() != wheel.getClass()) {
            return false;
        }
        Wheel newWheel = (Wheel) wheel;
        return radius == newWheel.radius;
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
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant create wheel ", e);
        }
    }
}

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

    protected Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public boolean equals(Object wheel) {
        if (this == wheel) {
            return true;
        }
        if (wheel == null || Wheel.class != wheel.getClass()) {
            return false;
        }
        Wheel otherWheel = (Wheel) wheel;
        return radius == otherWheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

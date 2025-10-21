package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private static final int PRIME_NUMBER_FOR_HASH_CODE = 17;
    private static final int PRIME_NUMBER_FOR_CALCULATE_HASH_CODE = 31;
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel otherWheel) {
        this.radius = otherWheel.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Wheel.class)) {
            Wheel currentWheel = (Wheel) o;
            return Objects.equals(this.radius, currentWheel.radius);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = PRIME_NUMBER_FOR_HASH_CODE;
        result = PRIME_NUMBER_FOR_CALCULATE_HASH_CODE * result + this.radius;
        return result;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone Wheel", e);
        }
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}

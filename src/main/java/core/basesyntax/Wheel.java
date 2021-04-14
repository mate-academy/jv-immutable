package core.basesyntax;

public class Wheel implements Cloneable {
    private static final int PRIME_NUMBER = 31;
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
        Wheel current = (Wheel) wheel;
        return radius == current.radius;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = PRIME_NUMBER * result + radius;
        return result;
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

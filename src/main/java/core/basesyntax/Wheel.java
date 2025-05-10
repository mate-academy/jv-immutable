package core.basesyntax;

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
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone");
        }
    }

    @Override
    public int hashCode() {
        int primeNumber = 17;
        primeNumber = 31 * primeNumber + radius;
        return primeNumber;
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
        return this.radius == current.radius;
    }

}

package core.basesyntax;

public class Wheel implements Cloneable{
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
        return new Wheel(radius);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Wheel wheel = (Wheel) other;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        int result = radius;
        int prime = 41;
        result = prime * result;
        return result;
    }
}

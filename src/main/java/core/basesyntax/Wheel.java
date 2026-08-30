package core.basesyntax;

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
    public int hashCode() {
        return Integer.hashCode(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wheel other = (Wheel) obj;
        return radius == other.radius;
    }

    @Override
    public String toString() {
        return "Wheel{radius=" + radius + '}';
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }
}

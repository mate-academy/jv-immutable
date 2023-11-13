package core.basesyntax;

public final class Wheel implements Cloneable {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    //implement this class

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create a clone of Engine object", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius && o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return radius;
    }
    public int getRadius() {
        return this.radius;
    }


    public Wheel setRadius(int i) {
        return new Wheel(i);
    }
}

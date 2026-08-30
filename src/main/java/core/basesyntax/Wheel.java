package core.basesyntax;

public class Wheel implements Cloneable {
    private static final int MAGIC_HASH_MULTIPLICATOR = 31;
    private static final int MAGIC_HASH_CONSTANT = 15;

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
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException " + e);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return MAGIC_HASH_MULTIPLICATOR * MAGIC_HASH_CONSTANT + radius;
    }
}

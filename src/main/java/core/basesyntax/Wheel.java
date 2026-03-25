package core.basesyntax;

public class Wheel implements Cloneable {
    private static final int PRIME = 59;
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Could not create clone of Wheel object", e);
        }

    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Wheel)) {
            return false;
        }
        final Wheel other = (Wheel) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getRadius() != other.getRadius()) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Wheel;
    }

    public int hashCode() {
        int result = 1;
        result = result * PRIME + this.getRadius();
        return result;
    }
}

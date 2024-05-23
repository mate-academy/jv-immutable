package core.basesyntax;

public final class Wheel implements Cloneable {
    private final String CLONE_ERROR = "Failed to clone wheel";
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(CLONE_ERROR, e);
        }
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
    public int hashCode() {
        return radius * CLONE_ERROR.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof Wheel castedObject &&
                (this == castedObject
                        || this.radius == castedObject.radius);
    }
}

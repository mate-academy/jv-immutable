package core.basesyntax;

public final class Wheel implements Cloneable {
    private int radius;
    //implement this class

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
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone wheel: ", e);
        }
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + radius;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(Wheel.class)) {
            Wheel wheel = (Wheel) obj;
            return wheel.getRadius() == radius;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

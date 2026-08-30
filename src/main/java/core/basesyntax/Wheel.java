package core.basesyntax;

public class Wheel implements Cloneable {
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        return result;
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
            throw new RuntimeException("Can't cloe Wheel!", e);
        }
    }
}

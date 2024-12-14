package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can not clone object",e);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (radius);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wheel current = (Wheel) obj;
        return radius == current.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }
}

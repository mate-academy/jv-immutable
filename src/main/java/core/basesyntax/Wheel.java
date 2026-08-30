package core.basesyntax;

public class Wheel implements Cloneable {
    private Integer radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    public int hashCode() {
        int hash = 17;
        return hash * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wheel o = (Wheel) obj;
        return radius == o.getRadius();
    }
}

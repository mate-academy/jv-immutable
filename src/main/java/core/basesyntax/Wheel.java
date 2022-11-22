package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        Integer radiusInteger = radius;
        int result = 17;
        result = 31 * result * (radiusInteger == null ? 0 : radiusInteger.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Integer radiusInteger = radius;
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj.getClass().equals(Wheel.class)) {
            Wheel current = (Wheel) obj;
            return (radiusInteger == null
                    ? current.getRadius() == 0 : radiusInteger.equals(current.getRadius()));
        }
        return false;
    }

    @Override
    protected Wheel clone() {
        return new Wheel(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

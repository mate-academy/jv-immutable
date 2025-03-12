package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Wheel setRadius(int radius) {
        return new Wheel(radius);
    }

    @Override
    public Wheel clone() {
        return new Wheel(this.radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wheel{");
        sb.append("radius=").append(radius)
                .append('}');
        return sb.toString();
    }
}

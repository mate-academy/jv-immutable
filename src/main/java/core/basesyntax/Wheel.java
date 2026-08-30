package core.basesyntax;

import java.util.Objects;

public final class Wheel implements Cloneable {
    private int radius;
    private String brand;

    public Wheel(int radius, String brand) {
        this.radius = radius;
        this.brand = brand;
    }

    public Wheel(int radius) {
        this(radius, "default");
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getBrand() {
        return brand;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel)) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius && Objects.equals(brand, wheel.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, radius);
    }
    //implement this class

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
            return new Wheel(this.radius, this.brand);
        }
    }
}

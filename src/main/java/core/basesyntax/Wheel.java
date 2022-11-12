package core.basesyntax;

import java.util.Objects;

public class Wheel implements Cloneable {
    private Integer radius;

    public Wheel(int radius) {
        super();
        this.radius = radius;
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

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    public Wheel clone() {
        Wheel clonedWheel;
        try {
            clonedWheel = (Wheel) super.clone();
            clonedWheel.setRadius(clonedWheel.radius);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant clone it ", e);
        }
        return clonedWheel;
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
        return Objects.equals(getRadius(), wheel.getRadius());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel() {
    }

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
        if (this == o) {
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
        return Objects.hash(radius);
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't make the copy of Wheel object", e);
        }
    }

    public List<Wheel> getClonedList(List<Wheel> wheels) {
        List<Wheel> copies = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copies.add(wheel.clone());
        }
        return copies;
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}

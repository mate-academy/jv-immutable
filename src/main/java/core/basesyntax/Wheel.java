package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class
    public Wheel() {
    }

    public Wheel(int radius) {
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
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create the clone for Wheel object", e);
        }
    }

    public List<Wheel> getClone(List<Wheel> wheels) {
        List<Wheel> cloneWheelsList = new ArrayList<>(wheels.size());

        for (Wheel wheel : wheels) {
            cloneWheelsList.add(wheel.clone());
        }

        return cloneWheelsList;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

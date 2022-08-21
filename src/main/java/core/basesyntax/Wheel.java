package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (this == o) {
            return true;
        }
        if (! (o instanceof Wheel)) {
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

    public static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Wheel object ",e);
        }
    }

}

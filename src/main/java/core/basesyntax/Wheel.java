package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Wheel implements Cloneable {
    private int radius;

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
        Wheel current = (Wheel) o;
        return this.radius == current.radius;
    }

    @Override
    public int hashCode() {
        int result = 11;
        result *= 23 + radius;
        return result;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot create clone for Wheel object", e);
        }
    }

    public static List<Wheel> cloneWheel(List<Wheel> wheels) {
        List<Wheel> newListOfWheels = new ArrayList<>();
        for (Wheel each : wheels) {
            newListOfWheels.add(each.clone());
        }
        return newListOfWheels;
    }
}

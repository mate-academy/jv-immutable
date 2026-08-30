package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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
        return radius;
    }

    //TODO
    public static List<Wheel> deepCloneList(List<Wheel> list) {
        List<Wheel> clonedList = new ArrayList<>(list.size());
        for (Wheel item : list) {
            clonedList.add(item.clone());
        }
        return clonedList;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}

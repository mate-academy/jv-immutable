package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    Car(int year, String color, List<Wheel> wheelList, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getListCopy(wheelList);
        this.engine = (engine == null ? null : engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = getListCopy(wheels);
        list.add(wheel);
        return new Car(year, color, list, engine);
    }

    public Car changeColor(String blue) {
        return new Car(year,blue, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getListCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    private List<Wheel> getListCopy(List<Wheel> list1) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel i : list1) {
            newList.add(i.clone());
        }
        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can not clone", e);
        }
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }
}

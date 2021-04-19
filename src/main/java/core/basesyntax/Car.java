package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, cloneList(wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, cloneList(wheels), engine.clone());
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newList = cloneList(wheels);
        newList.add(wheel);
        return new Car(year, color, newList, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> cloneList(List<Wheel> wheels) {
        List<Wheel> clonedList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedList.add(wheel.clone());
        }
        return clonedList;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create copy of car");
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
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

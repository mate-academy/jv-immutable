package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels);
        this.engine = null == engine ? null : engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = getWheels();
        list.add(newWheel);
        return new Car(getYear(), getColor(), list, getEngine());
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public Engine getEngine() {
        return null == engine ? null : engine.clone();
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
        return year == car.year && color.equals(car.color) && wheels.equals(car.wheels)
                && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

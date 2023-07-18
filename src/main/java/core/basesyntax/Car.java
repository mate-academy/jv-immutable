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
        this.wheels = copyArray(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyArray(wheels);
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);

    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = copyArray(getWheels());
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine.clone());
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

    private List<Wheel> copyArray(List<Wheel> list) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel item : list) {
            newWheels.add(item.clone());
        }
        return newWheels;
    }
}

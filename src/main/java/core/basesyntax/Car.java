package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    private final ArrayList<Wheel> localWheels;
    private final Engine localEngine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);

        localWheels = cloneWheels(wheels);
        localEngine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, localWheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, localWheels, localEngine);
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(year, color, localWheels, localEngine);
        car.wheels.add(wheel.clone());
        return car;
    }

    private ArrayList<Wheel> cloneWheels(List<Wheel> wheels) {
        ArrayList<Wheel> result = new ArrayList<>();
        for (Wheel wheel : wheels) {
            result.add(wheel.clone());
        }
        return result;
    }

    private Engine cloneEngine(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
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

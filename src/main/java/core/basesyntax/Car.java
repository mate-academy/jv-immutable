package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneListOfWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        return cloneListOfWheels(wheels);
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(wheel.clone());
        return car;
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> cloneListOfWheels(List<Wheel> oldListOfWheels) {
        List<Wheel> cloneWheels = new ArrayList<>();
        for (Wheel wheel : oldListOfWheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }

    public int getYear() {
        return year;
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


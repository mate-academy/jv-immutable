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
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel.clone());
        return car;
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

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null || Car.class != car.getClass()) {
            return false;
        }
        Car otherCar = (Car) car;
        return year == otherCar.year
                && Objects.equals(color, otherCar.color)
                && Objects.equals(wheels, otherCar.wheels)
                && Objects.equals(engine, otherCar.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel == null) {
                clonedWheels.add(null);
            } else {
                clonedWheels.add(wheel.clone());
            }
        }
        return clonedWheels;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

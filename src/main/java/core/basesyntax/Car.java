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
        this.wheels = cloneList(wheels);
        this.engine = cloneEngine(engine);
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
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel.clone());
        return car;
    }

    private List<Wheel> cloneList(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                newWheels.add(wheel.clone());
            } else {
                newWheels.add(null);
            }
        }
        return newWheels;
    }

    private Engine cloneEngine(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    @Override
    public boolean equals(Object testCar) {
        if (this == testCar) {
            return true;
        }
        if (testCar == null || getClass() != testCar.getClass()) {
            return false;
        }
        Car car = (Car) testCar;
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

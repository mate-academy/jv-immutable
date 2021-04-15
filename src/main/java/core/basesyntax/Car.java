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
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car otherCar = (Car) object;
        return year == otherCar.year
                && Objects.equals(color, otherCar.color)
                && Objects.equals(wheels, otherCar.wheels)
                && Objects.equals(engine, otherCar.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheelList) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheelList) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

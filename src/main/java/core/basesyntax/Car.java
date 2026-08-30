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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    public Car changeEngine(Engine newEngine) {
        Car newCar = new Car(year, color, wheels, newEngine);
        return newCar;
    }

    public Car changeColor(String newColor) {
        Car newCar = new Car(year, newColor, wheels, engine);
        return newCar;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        Car newCar = new Car(year, color, newWheels, engine);
        return newCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null || getClass() != car.getClass()) {
            return false;
        }
        Car current = (Car) car;
        return Objects.equals(this.color, current.color)
                && Objects.equals(this.wheels, current.wheels)
                && Objects.equals(this.engine, current.engine)
                && (this.year == current.year);
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

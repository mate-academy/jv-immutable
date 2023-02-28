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
        List<Wheel> newListWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListWheel.add(wheel.clone());
        }
        this.wheels = newListWheel;
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newListWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListWheel.add(wheel.clone());
        }
        return newListWheel;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newListWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListWheels.add(wheel);
        }
        newListWheels.add(newWheel);
        return new Car(this.year, this.color, newListWheels, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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

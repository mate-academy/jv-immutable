package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        List<Wheel> newWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }

        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }

        this.year = year;
        this.color = color;
        this.wheels = newWheel;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        Car newCarWithNewEngine = new Car(this.year, this.color, this.getWheels(), engine);
        return newCarWithNewEngine;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> currentWheels = this.getWheels();
        currentWheels.add(newWheel);
        Car newCarWithNewWheels = new Car(this.year, this.color,
                currentWheels, this.engine.clone());
        return newCarWithNewWheels;
    }

    public Car changeColor(String newColor) {
        Car newCarWithNewColor = new Car(this.year, newColor, this.wheels, this.engine.clone());
        return newCarWithNewColor;
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
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

}

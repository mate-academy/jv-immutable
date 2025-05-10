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

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        this.wheels = copyWheels;
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return new Car(year, color, copyWheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return new Car(year, newColor, copyWheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        copyWheels.add(newWheel);
        return new Car(year, color, copyWheels, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.year == car.year
                && Objects.equals(this.color, car.color)
                && Objects.equals(this.wheels, car.wheels)
                && Objects.equals(this.engine, car.engine);
    }

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

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
        this.year = year;
        this.color = color;
        this.wheels = wheelCopy(wheels);
        this.engine = engineCopy(engine);
    }

    public Car changeEngine(Engine newEngine) {
        if (newEngine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        return new Car(this.year, this.color, this.wheels, engineCopy(newEngine));
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheelCopy(wheels));
    }

    public Car addWheel(Wheel wheel) {
        if (wheel == null) {
            throw new IllegalArgumentException("Wheel cannot be null");
        }
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(wheel.clone());
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private List<Wheel> wheelCopy(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            Wheel clonedWheel = wheel.clone();
            copiedWheels.add(clonedWheel);
        }
        return copiedWheels;
    }

    private Engine engineCopy(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
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


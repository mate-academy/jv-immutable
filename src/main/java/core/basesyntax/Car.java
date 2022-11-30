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
        List<Wheel> wheelcopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelcopy.add(wheel.clone());
        }
        this.wheels = wheelcopy;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelcopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelcopy.add(wheel.clone());
        }
        return wheelcopy;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> whellCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            whellCopy.add(wheel.clone());
        }
        whellCopy.add(newWheel);
        return new Car(year, color, whellCopy, engine);
    }
}

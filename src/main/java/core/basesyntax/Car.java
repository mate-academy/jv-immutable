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
        this.wheels = getWheels1(wheels);
        this.engine = engine == null? null : engine.clone();
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

    public Car changeEngine(Engine engine) {
         return new Car(getYear(), getColor(), getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
         List<Wheel> allWheels = new ArrayList<>();
         for (Wheel wheel : wheels) {
             allWheels.add(wheel.clone());
         }
         allWheels.add(newWheel);
         return new Car(getYear(), getColor(), allWheels, getEngine());
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

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels1(List<Wheel> list) {
        if (wheels == null) {
            return new ArrayList<>();
        }
        List<Wheel> allWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            allWheels.add(wheel.clone());
        }
        return allWheels;
    }

    public List<Wheel> getWheels() {
        if (wheels == null) {
            return new ArrayList<>();
        }
        List<Wheel> allWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            allWheels.add(wheel.clone());
        }
        return allWheels;
    }
}

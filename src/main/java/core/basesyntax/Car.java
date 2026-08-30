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
        List<Wheel> wheelsCopy = new ArrayList<>();
        if (wheels != null) {
            for (Wheel wheel : wheels) {
                wheelsCopy.add(wheel.clone());
            }
        }
        this.wheels = wheelsCopy;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
        if (wheels == null) {
            throw new NullPointerException();
        }
    }

    public Car changeEngine(Engine engine) {
        Car newCar = new Car(this.year, this.color, this.wheels, engine);
        return newCar;
    }

    public Car changeColor(String newColor) {
        Car newCarm = new Car(this.year, newColor, this.wheels, this.engine);
        return newCarm;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> deepCopyOfWheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel existingWheel : wheels) {
                deepCopyOfWheels.add(existingWheel.clone());
            }
        }
        deepCopyOfWheels.add(newWheel);
        return new Car(this.year, this.color, deepCopyOfWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCop = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCop.add(wheel.clone());
        }
        return wheelsCop;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
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

    //implement this class

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

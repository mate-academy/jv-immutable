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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.engine = (engine == null) ? null : engine.clone();
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public int getYear() {
        return Integer.valueOf(year);
    }

    public String getColor() {
        return String.valueOf(color);
    }

    public List<Wheel> getWheels() {
        List<Wheel> forReturn = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            forReturn.add(wheel.clone());
        }
        return forReturn;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
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

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsClone = new ArrayList<>((wheels.size() + 1));
        for (Wheel whee : wheels) {
            wheelsClone.add(whee.clone());
        }
        wheelsClone.add(wheel);
        return new Car(year, color, wheelsClone, engine);
    }

    public Car changeEngine(Engine eng) {
        return new Car(year, color, wheels, eng);
    }

    public Car changeColor(String expected) {
        return new Car(year, expected, wheels, engine);
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
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }
}
package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final Integer year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        Objects.requireNonNull(wheels, "wheels must not be null");
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(Objects.requireNonNull(wheel, "wheel must not be null").clone());
        }
        this.wheels = Collections.unmodifiableList(wheelsCopy);
        this.engine = engine == null ? null : new Engine(engine);
    }

    public int getYear() {
        return year;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wh : wheels) {
            wheelsCopy.add(Objects.requireNonNull(wh, "wheel must not be null").clone());
        }
        wheelsCopy.add(wheel);
        return new Car(getYear(), getColor(), wheelsCopy, getEngine());
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car changeColor(String blue) {
        return new Car(getYear(), blue, getWheels(), getEngine());
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(year, car.year) && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(getYear(), getColor(), getWheels(), otherMaker);
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone of car object", e);
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
}

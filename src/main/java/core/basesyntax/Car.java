package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheelList(wheels);
        this.engine = cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> carWheels = getWheels();
        carWheels.add(wheel);
        return new Car(getYear(), getColor(), carWheels, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return cloneWheelList(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(this.engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
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
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Creating car clone doesn't supported", e);
        }
    }

    private static List<Wheel> cloneWheelList(List<Wheel> wheels) {
        List<Wheel> copyWheel = new ArrayList<>(wheels.size());
        for (Wheel x : wheels) {
            copyWheel.add(x.clone());
        }
        return copyWheel;
    }
}

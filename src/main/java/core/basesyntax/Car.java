package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = colonWheelList(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return colonWheelList(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = getWheels();
        newWheel.add(wheel);
        return new Car(getYear(), getColor(), newWheel, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null
               ? null
               : engine.clone();
    }

    private static List<Wheel> colonWheelList(List<Wheel> wheels) {
        List<Wheel> copyWheel = new ArrayList<>(wheels.size());
        wheels.stream().forEach(x -> copyWheel.add(x.clone()));
        return copyWheel;
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
            throw new RuntimeException("A clone of the \"Car\" object cannot be created", e);
        }
    }
}

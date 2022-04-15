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
        this.wheels = copyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 23;
        result += 31 * year + color.hashCode() + wheels.hashCode() + engine.hashCode();
        return result;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (object.getClass() == Car.class) {
            Car car = (Car) object;
            return this.year == car.year
                    && Objects.equals(this.color, car.color)
                    && Objects.equals(this.wheels, wheels)
                    && Objects.equals(this.engine, car.engine);
        }

        return false;
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

    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, copyWheels(wheels), otherMaker.clone());
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels = new ArrayList<>(getWheels());
        wheels.add(wheel);
        return new Car(year, color, wheels, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(year, color, copyWheels(wheels), engine.clone());
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }
}

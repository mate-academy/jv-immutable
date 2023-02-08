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
        this.color = new String(color);
        this.wheels = new ArrayList<>(wheels);
        this.engine = engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car changeEngine(Engine engine) {
        return this;
    }

    public Car addWheel(Wheel wheel) {
        return this;
    }

    public Car changeColor(String color) {
        return this;
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

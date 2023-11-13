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
        this.color = color;
        this.wheels = makeCopyOfWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = makeCopyOfWheels(wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public List<Wheel> getWheels() {
        return makeCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    private List<Wheel> makeCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> copyWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheel.add(wheel.clone());
        }

        return copyWheel;
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * There are three classes: Car, Engine, and Wheel. Make class Car immutable.
 * <p>
 * Implement method changeEngine(Engine engine), which will allow you to upgrade your car
 * Implement method changeColor(String newColor).
 * Implement method addWheel(Wheel newWheel). Our car can have as many wheels as possible)
 * You also should implement equals() and hashCode() methods and constructor with all
 * arguments in all classes, in order for the tests to run correctly.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = deepCopyOfListWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(this.wheels);
        newWheelsList.add(newWheel);
        return new Car(this.year, this.color, newWheelsList, this.engine);
    }

    private List<Wheel> deepCopyOfListWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        return copy;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyOfListWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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
}

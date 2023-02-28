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
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (int i = 0; i < wheels.size(); i++) {
            wheelsCopy.add(i, wheels.get(i).clone());
        }
        this.year = year;
        this.color = color;
        this.wheels = wheelsCopy;
        this.engine = engine == null ? null : engine.clone();
    }

    @Override
    public Car clone() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (int i = 0; i < wheels.size(); i++) {
            wheelsCopy.add(i, wheels.get(i).clone());
        }
        Car car = new Car(year, color, wheelsCopy, engine);
        return car;
    }

    public Car changeEngine(Engine engine) {
        Car car = new Car(this.year, this.color, this.wheels, engine);
        return car;
    }

    public Car changeColor(String newColor) {
        Car car = new Car(this.year, newColor, this.wheels, this.engine);
        return car;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        Car clone = this.clone();
        return clone.wheels;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        Car clone = this.clone();
        clone.wheels.add(newWheel);
        return clone;
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
}

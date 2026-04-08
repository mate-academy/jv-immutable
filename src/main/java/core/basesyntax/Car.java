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
        this.wheels = this.getWheelsDeepCopy(Objects.requireNonNull(wheels));
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return this.getWheelsDeepCopy(this.wheels);
    }

    public Engine getEngine() {
        return this.engine != null ? this.engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(this.wheels);
        wheelsCopy.add(newWheel);
        return new Car(this.year, this.color, wheelsCopy, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Car other = (Car) o;

        return this.year == other.year
                && Objects.equals(this.color, other.color)
                && Objects.equals(this.wheels, other.wheels)
                && Objects.equals(this.engine, other.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.year, this.color, this.wheels, this.engine);
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + this.year
            + ", color='" + this.color + '\''
            + ", wheels=" + this.wheels
            + ", engine=" + this.engine
            + '}';
    }

    private List<Wheel> getWheelsDeepCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

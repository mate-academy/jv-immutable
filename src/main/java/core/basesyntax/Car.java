package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        this.wheels = copyOf(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyOf(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result *= 17 * year;
        result *= 17 * (color == null ? 0 : color.hashCode());
        result *= 17 * (wheels == null ? 0 : wheels.hashCode());
        result *= 17 * (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !o.getClass().equals(Car.class)) {
            return false;
        }
        Car other = (Car) o;
        return year == other.year
                && color == other.color || color != null && color.equals(other.color)
                && wheels == other.wheels || wheels != null && wheels.equals(other.wheels)
                && engine == other.engine || engine != null && engine.equals(other.engine);
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

    private List<Wheel> copyOf(List<Wheel> wheels) {
        return wheels.stream().map(Wheel::clone).collect(Collectors.toList());
    }
}

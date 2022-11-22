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
        this.wheels = deepClone(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepClone(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car other = (Car) obj;
            return this.year == other.year
                    && Objects.equals(this.color, other.color)
                    && Objects.equals(this.wheels, other.wheels)
                    && Objects.equals(this.engine, other.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 101;
        result = 67 * result + year;
        result = 67 * result + (color == null ? 0 : color.hashCode());
        result = 67 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 67 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    private List<Wheel> deepClone(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        if (wheels.size() > 0) {
            for (Wheel wheel : wheels) {
                clonedWheels.add(wheel.clone());
            }
        }
        return clonedWheels;
    }
}

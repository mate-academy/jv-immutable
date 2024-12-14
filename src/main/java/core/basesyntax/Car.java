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

    // Constructor for initialization
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        // Create a deep copy of the wheels list
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());  // Ensure that Wheel implements Cloneable and has a clone method
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            // Create a new Engine object to preserve immutability
            return engine.clone();
        }
        return null;
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

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine.clone());
    }

    public Car addWheel(Wheel wheel) {
        // Create a new list for wheels and add a clone of the new wheel
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car current = (Car) obj;
        return year == current.year
                && Objects.equals(color, current.color)
                && Objects.equals(wheels, current.wheels)
                && Objects.equals(engine, current.engine);
    }
}
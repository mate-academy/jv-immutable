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

    // implement this class
    public Car(Engine engine, List<Wheel> wheels, int year, String color) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels);
        this.engine = engine;
    }

    public int getYear() {
        return this.year;
    }
    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Car changeEngine(Engine engine) {
        return new Car(engine, wheels, year, color);
    }

    public Car changeColor(String color) {
        return new Car(engine, wheels, year, color);
    }

    public Car changeWheel(Wheel wheel) {
        List<Wheel> wheelsCollection = new ArrayList<>();
        wheelsCollection.add(wheel);
        return new Car(engine, wheelsCollection, year, color);
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Self-check: Is it the same object?
        if (this == obj) {
            return true;
        }

        // 2. Null-check: Is the other object null?
        if (obj == null) {
            return false;
        }

        // 3. Type-check: Is the other object of the same class?
        // Using getClass() ensures strict class equality, while instanceof allows
        // subclasses.
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 4. Cast: Cast the object to the correct type
        Car other = (Car) obj;

        // 5. Field comparison: Compare significant fields
        // For primitive types, use ==.
        // For object types, use Objects.equals() to handle nulls gracefully.
        return this.year == other.year &&
                Objects.equals(this.color, other.color)
                && Objects.equals(this.wheels, other.wheels)
                && Objects.equals(this.engine, other.engine);
    }

    // 6. Override hashCode: Always override hashCode when overriding equals.
    // Ensure that equal objects have equal hash codes.
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

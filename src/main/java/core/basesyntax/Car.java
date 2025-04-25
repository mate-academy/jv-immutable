package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final Engine engine;
    private final String color;
    private final List<Wheel> wheels;
    private final int year;

    public Car(Engine engine, String color, List<Wheel> wheels, int year) {
        this.engine = engine;
        this.color = color;
        this.wheels = new ArrayList<>(wheels); // захист від зміни зовні
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(newEngine, this.color, this.wheels, this.year);
    }

    public Car changeColor(String newColor) {
        return new Car(this.engine, newColor, this.wheels, this.year);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel);
        return new Car(this.engine, this.color, newWheels, this.year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(color, car.color) &&
                Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color, wheels, year);
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

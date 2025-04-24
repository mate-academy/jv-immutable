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

    public Car(int year, String color, List<Wheel>, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels); // захист від зміни зовні
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
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
        return new Car(this.year, this.color, this.engine, newWheels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
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

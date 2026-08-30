package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel w : wheels) {
            copiedWheels.add(new Wheel(w));
        }

        this.wheels = Collections.unmodifiableList(new ArrayList<>(copiedWheels));
        this.engine = engine == null ? null : new Engine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(new Wheel(w));
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getWheels(), getEngine());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels,
                car.wheels) && Objects.equals(engine, car.engine);
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

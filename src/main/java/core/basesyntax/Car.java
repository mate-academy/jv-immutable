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
        if (wheels == null) {
            throw new NullPointerException("");
        }
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            try {
                clonedWheels.add((Wheel) wheel.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        this.wheels = clonedWheels;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
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

        for (Wheel wheel : this.wheels) {
            try {
                clonedWheels.add((Wheel) wheel.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return this;
        }

        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            try {
                clonedWheels.add((Wheel) wheel.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        clonedWheels.add(newWheel);
        return new Car(year, color, clonedWheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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

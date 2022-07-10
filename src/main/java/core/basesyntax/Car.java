package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;
    private final int year;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.color = color;
        this.wheels = copyOfWheels(wheels);
        this.engine = copyOfEngine(engine);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyOfWheels(wheels);
    }

    public Engine getEngine() {
        return copyOfEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, copyOfEngine(engine));
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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
        return Objects.hash(color, wheels, engine, year);
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

    private List<Wheel> copyOfWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    private Engine copyOfEngine(Engine engine) {
        return (engine != null) ? engine.clone() : null;
    }
}

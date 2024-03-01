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
        this.wheels = copyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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

    public List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> newCopyWheels = new ArrayList<>();
        for (Wheel whe : wheels) {
            newCopyWheels.add(whe.clone());
        }
        return newCopyWheels;
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
        if (year == 0 ? car.year != 0 : year != car.year) {
            return false;
        }
        if (color == null ? car.color != null : !color.equals(car.color)) {
            return false;
        }
        if (wheels == null ? car.wheels != null : !wheels.equals(car.wheels)) {
            return false;
        }
        if (engine == null ? car.engine != null : !engine.equals(car.engine)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color,newWheels, engine.clone());
    }
}

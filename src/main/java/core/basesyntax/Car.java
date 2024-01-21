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
        this.wheels = getNewListOfWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getNewListOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return getYear() == car.getYear()
                && getColor().equals(car.getColor())
                && getWheels().equals(car.getWheels())
                && getEngine().equals(car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newListOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListOfWheels.add(wheel.clone());
        }
        newListOfWheels.add(newWheel);
        return new Car(year, color, newListOfWheels, engine);
    }

    private static List<Wheel> getNewListOfWheels(List<Wheel> wheels) {
        List<Wheel> newListOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newListOfWheels.add(wheel.clone());
        }
        return newListOfWheels;
    }

    //implement this class
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

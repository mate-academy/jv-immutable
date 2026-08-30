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
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        this.wheels = newWheels;
        this.engine = getEngineNullable(engine);
    }

    private Engine getEngineNullable(Engine engine) {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedList.add(wheel.clone());
        }
        clonedList.add(newWheel);
        return new Car(year, color, clonedList, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        return getEngineNullable(this.engine);
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return Objects.equals(this.color, current.color)
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine)
                    && this.year == current.year;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * result + (color == null ? 0 : color.hashCode());
        result += 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result += 31 * result + (engine == null ? 0 : engine.hashCode());
        result += 31 * result + year;
        return result;
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

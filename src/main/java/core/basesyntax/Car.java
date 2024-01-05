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
        if (wheels == null) {
            throw new NullPointerException("Wheels can't be null");
        }
        this.year = year;
        this.color = color;
        this.wheels = getClonedWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return getClonedWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getClonedWheels(wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getClonedWheels(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedWheels = getClonedWheels(wheels);
        clonedWheels.add(newWheel);
        return new Car(year, color, clonedWheels, engine.clone());
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Car newCar = (Car) o;
        return this.year == newCar.year
                && Objects.equals(this.color, newCar.color)
                && Objects.equals(this.wheels, newCar.wheels)
                && Objects.equals(this.engine, newCar.engine);
    }

    private List<Wheel> getClonedWheels(List<Wheel> wheels) {
        if (wheels == null) {
            return null;
        }
        List<Wheel> clonedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }
}

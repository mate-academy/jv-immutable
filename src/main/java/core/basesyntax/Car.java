package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        Car changedCar = new Car(year, color, wheels, engine.clone());
        return changedCar;
    }

    public Car changeColor(String color) {
        Car changedCar = new Car(year, color, wheels, engine);
        return changedCar;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsCopy = getWheels();
        wheelsCopy.add(wheel.clone());
        Car changedCar = new Car(year, color, wheelsCopy, engine);
        return changedCar;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + (wheels == null ? 0 : wheels.hashCode());
        result = result * 17 + (engine == null ? 0 : engine.hashCode());
        result = result * 17 + Integer.valueOf(year).hashCode();
        result = result * 17 + (color == null ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final Car currentCar = (Car) obj;
        return Objects.equals(wheels, currentCar.wheels)
                && Objects.equals(engine, currentCar.engine)
                && year == currentCar.year
                && Objects.equals(color, currentCar.color);
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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone a car ", e);
        }
    }
}

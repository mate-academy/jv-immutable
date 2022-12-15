package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();

    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (wheels.isEmpty()) {
            return null;
        }
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(wheels.size() + 1);
        for (Wheel wheel : wheels) {
            newWheelsList.add(wheel);
        }
        newWheelsList.add(newWheel);
        return new Car(year, color, newWheelsList, engine);
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
            return this.color.equals(current.color)
                    && this.year == current.year
                    && Objects.equals(engine, current.engine)
                    && Objects.equals(wheels, current.wheels);
        }
        return false;
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
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

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<Wheel>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add((Wheel) wheel.clone());
        }
        return clonedWheels;
    }
}

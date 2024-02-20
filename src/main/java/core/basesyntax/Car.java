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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel));
        }
        this.engine = engine != null
                ? engine.clone()
                : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheels = new ArrayList<>(this.wheels);
        updatedWheels.add(newWheel);
        return new Car(this.year, this.color, updatedWheels, this.engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            deepCopy.add(wheel.clone());
        }

        return deepCopy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }

        return engine.clone();
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
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }

        if (car == null) {
            return false;
        }

        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year
                    && Objects.equals(this.color, current.color)
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine);
        }

        return false;
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

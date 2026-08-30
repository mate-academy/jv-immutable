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
        this.wheels = getWheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, getWheelsCopy(this.wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getWheelsCopy(this.wheels), this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheelsCopy(this.wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year
                    && Objects.equals(this.color, current.color)
                    && this.wheels.equals(current.wheels)
                    && this.engine.equals(current.engine);
        }
        return false;
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

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

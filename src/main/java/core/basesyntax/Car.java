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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && color.equals(car.color)
                && wheels.equals(car.wheels) && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheelToCar(Wheel newWheel) {
        List<Wheel> newWheels = cloneWheels(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    public List<Wheel> cloneWheels(List<Wheel> toClone) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : toClone) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (wheels == null) {
            return null;
        } else {
            return cloneWheels(wheels);
        }
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }
}

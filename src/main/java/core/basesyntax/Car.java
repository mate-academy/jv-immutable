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
        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null");
        }
        this.year = year;
        this.color = color;
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        this.wheels = copiedWheels;
        this.engine = engine == null ? null : new Engine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null || car.getClass() != Car.class) {
            return false;
        }
        Car castCar = (Car) car;
        return year == castCar.year
                && Objects.equals(color, castCar.color)
                && Objects.equals(wheels, castCar.wheels)
                && Objects.equals(engine, castCar.engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + wheels.hashCode();
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return new Car(year, color, copiedWheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return new Car(year, newColor, copiedWheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        copiedWheels.add(newWheel.clone());//
        return new Car(year, color, copiedWheels, engine.clone());
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

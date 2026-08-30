package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel oneWheel : wheels) {
            copyWheels.add(oneWheel.clone());
        }
        this.wheels = copyWheels;
        this.engine = engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel oneWheel : wheels) {
            copyWheels.add(oneWheel.clone());
        }
        return copyWheels;
    }

    public Car changeEngine(Engine engine) {
        Car newCar = new Car(year, color, getWheels(), engine);
        return newCar;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = getWheels();
        copyWheels.add(newWheel);
        Car newCar = new Car(year, color, copyWheels, engine.clone());
        return newCar;
    }

    public Car changeColor(String newColor) {
        Car newCar = new Car(year, newColor, getWheels(), engine.clone());
        return newCar;
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

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Car object", e);
        }
    }
}

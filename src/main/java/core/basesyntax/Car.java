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
        this.wheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            throw new NullPointerException();
        }
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        Engine engineCopy = new Engine(engine.getHorsePower(), engine.getManufacturer());
        Car newCar = new Car(year, color, wheelsCopy, engineCopy);
        return newCar;
    }

    public Car changeColor(String newColor) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        Engine engineCopy = new Engine(engine.getHorsePower(), engine.getManufacturer());
        Car newCar = new Car(year, newColor, wheelsCopy, engineCopy);
        return newCar;
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return new Car(year, color, getWheels(), getEngine());
        }
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size() + 1);
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        wheelsCopy.add(newWheel.clone());
        Engine engineCopy = new Engine(engine.getHorsePower(), engine.getManufacturer());
        return new Car(year, color, wheelsCopy, engineCopy);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }
}

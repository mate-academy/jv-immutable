package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.engine = engine;
    }

    public Car changeEngine(Engine engine) {
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
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        wheelsCopy.add(newWheel.clone());
        Engine engineCopy = new Engine(engine.getHorsePower(), engine.getManufacturer());
        Car newCar = new Car(year, color, wheels, engineCopy);
        return newCar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
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
        Engine cloneEngine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        return cloneEngine;
    }
}

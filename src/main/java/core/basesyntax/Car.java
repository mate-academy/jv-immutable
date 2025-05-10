package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> clonedWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheel.add(wheel.clone());
        }
        this.wheels = clonedWheel;
        if (engine == null) {
            this.engine = engine;
        } else {
            this.engine = engine.clone();
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels,
                new Engine(engine.getHorsePower(), engine.getManufacturer()));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels1 = new ArrayList<>(wheels);
        wheels1.add(newWheel);
        return new Car(year, color, wheels1, engine);
    }

    public Engine getEngine() {
        if (engine == null) {
            return engine;
        } else {
            return engine.clone();
        }
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheel.add(wheel.clone());
        }
        return clonedWheel;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
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
        int result = 3;
        result = result * year;
        result = result * color.hashCode();
        result = result * wheels.hashCode();
        result = result * engine.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Car currentCar = (Car) obj;
        if (currentCar == null) {
            return false;
        }
        return (year == currentCar.year && color.equals(currentCar.color)
                && wheels.equals(currentCar.wheels) && engine.equals(currentCar.engine));
    }
}

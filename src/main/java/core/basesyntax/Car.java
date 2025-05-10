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
        this.wheels = getCopyOfWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year,color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheelsArray = getWheels();
        newWheelsArray.add(wheel);
        return new Car(year, color, newWheelsArray, engine);
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

    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    private List<Wheel> getCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> newListOfWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newListOfWheels.add(wheel.clone());
        }
        return new ArrayList<>(newListOfWheels);
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
        return year == car.year && color == car.color
                && wheels.equals(car.wheels) && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return year + color.hashCode() + wheels.hashCode() + engine.hashCode();
    }
}

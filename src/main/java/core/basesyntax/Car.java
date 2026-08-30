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
        List<Wheel> newWheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheelList.add(wheel.clone());
        }
        this.wheels = newWheelList;
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

        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!wheels.equals(car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + wheels.hashCode();
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheelList.add(wheel.clone());
        }
        return newWheelList;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        Car newCar = new Car(year, color, getWheels(), engine.clone());
        return newCar;
    }

    public Car changeColor(String newColor) {
        Car newCar = new Car(year, newColor, getWheels(), engine.clone());
        return newCar;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = new ArrayList<>(getWheels());
        newWheelsList.add(newWheel);
        Car newCar = new Car(year, color, newWheelsList, engine.clone());
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
}

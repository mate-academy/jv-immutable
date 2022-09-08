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
        List<Wheel> tempWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            tempWheels.add(wheel.clone());
        }
        this.wheels = tempWheels;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor,wheels,engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(newWheel);
        return newCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() &&
                getColor().equals(car.getColor()) &&
                getWheels().equals(car.getWheels()) &&
                getEngine().equals(car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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
        List<Wheel> tempWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            tempWheels.add(wheel.clone());
        }
        return tempWheels;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }
}

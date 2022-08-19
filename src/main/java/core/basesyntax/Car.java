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
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        this.year = year;
        this.color = color;
        this.wheels = wheelList;
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> newWheelsList = getWheels();
        return new Car(year,color,newWheelsList,engine);
    }

    public Car changeColor(String color) {
        List<Wheel> newWheelsList = getWheels();
        return new Car(year,color,newWheelsList,engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsList = getWheels();
        newWheelsList.add(newWheel);
        return new Car(year,color,newWheelsList,engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheelsList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheelsList.add(wheel.clone());
        }
        return newWheelsList;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
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
}

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
        this.wheels = deepCopyOfWheels(wheels);
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsTemp = new ArrayList<>(wheels);
        wheelsTemp.add(wheel);
        return new Car(year, color, wheelsTemp, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car currrent = (Car) car;
            return year == currrent.year && Objects.equals(color, currrent.color)
                    && Objects.equals(wheels, currrent.wheels)
                    && Objects.equals(engine, currrent.engine);
        }
        return false;
    }

    public int hashCode() {
        return year * color.hashCode() * wheels.hashCode() * engine.hashCode();
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

    private List<Wheel> deepCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> temp = new ArrayList<>();
        for (Wheel wheel : wheels) {
            temp.add(wheel.clone());
        }
        return temp;
    }
}

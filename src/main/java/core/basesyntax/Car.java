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
        this.wheels = getCopyWheels(wheels);// глибоке клонування
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor,wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newAddWheel = new ArrayList<>(wheels.size() + 1);
        int count = 0;
        for (Wheel i : wheels) {
            newAddWheel.add(i.clone());
            count++;
        }
        newAddWheel.add(count,newWheel);
        return new Car(year, color, newAddWheel, engine);
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>(getCopyWheels(wheels));
        return newWheels;
    }

    public List<Wheel> getCopyWheels(List<Wheel> listWheels) {
        List<Wheel> wheelCopy = new ArrayList<>(listWheels.size());
        for (Wheel wheel : listWheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create  clone of User object", e);
        }
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

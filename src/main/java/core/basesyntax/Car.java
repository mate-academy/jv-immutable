package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> immutable = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            immutable.add(wheel.clone());
        }
        this.wheels = immutable;
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        ArrayList<Wheel> immutableWheelsList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            immutableWheelsList.add(wheel.clone());
        }
        return immutableWheelsList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car carCopy = clone();
        carCopy.wheels.add(newWheel);
        return carCopy;
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), engine);
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
    protected Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public int hashCode() {
        return year
                * color.hashCode()
                * wheels.hashCode()
                * engine.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Car castedCar && year == castedCar.year
                && color.equals(castedCar.color)
                && wheels.equals(castedCar.wheels)
                && engine.equals(castedCar.engine);
    }
}

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
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        this.wheels = newWheels;
        this.engine = isNullObject(engine) ? null : engine.clone();
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Car", e);
        }
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return new Car(this.year, this.color, newWheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return new Car(this.year, newColor, newWheels, this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        if (!isNullObject(newWheel)) {
            newWheels.add(newWheel);
        }
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        return newWheel;
    }

    public Engine getEngine() {
        return isNullObject(this.engine) ? null : engine.clone();
    }

    private boolean isNullObject(Object obj) {
        return obj == null;
    }
}

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
        this.wheels = cloneWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> newWheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheelList.add(wheel.clone());
        }
        return newWheelList;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car)obj;
        return this.year == car.getYear() && this.color.equals(car.getColor())
                && this.wheels.equals(car.wheels) && this.engine.equals(car.engine);
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

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), getEngine());
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = getWheels();
        list.add(wheel);
        return new Car(getYear(), getColor(), list, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }
}

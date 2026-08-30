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
        this.wheels = copy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    //implement this class
    public Car changeEngine(Engine engine) {
        Car car = new Car(this.year, this.color, this.wheels, engine);
        return car;
    }

    public Car changeColor(String newColor) {
        Car car = new Car(this.year, newColor, this.wheels, this.engine);
        return car;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = copy(wheels);
        newWheelList.add(newWheel);
        return new Car(this.year, this.color, newWheelList, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
            throw new RuntimeException(e);
        }
    }

    private List<Wheel> copy(List<Wheel> oldWheels) {
        List<Wheel> newWheelList = new ArrayList<>(oldWheels.size());
        for (Wheel wheel : oldWheels) {
            newWheelList.add(wheel.clone());
        }
        return newWheelList;
    }
}

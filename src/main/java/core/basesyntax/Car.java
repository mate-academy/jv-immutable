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
        this.engine = (engine != null ? engine.clone() : null);
        this.wheels = getNewList(wheels);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = getNewList(this.wheels);
        newList.add((newWheel == null ? null : newWheel.clone()));
        return new Car(getYear(), getColor(), newList, getEngine());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getNewList(this.wheels);
    }

    public Engine getEngine() {
        return (engine != null ? engine.clone() : null);
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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if (car == null) {
            return false;
        }
        return car.year == this.year && Objects.equals(car.color, this.color)
                && car.engine.equals(this.engine) && Objects.equals(this.wheels, car.wheels);
    }

    private List<Wheel> getNewList(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newList.add(wheel == null ? null : wheel.clone());
        }
        return newList;
    }
}

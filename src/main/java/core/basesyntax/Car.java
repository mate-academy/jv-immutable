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
        this.wheels = getWheelsCopy(wheels);
        this.engine = getEngineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(this.wheels);
    }

    public Engine getEngine() {
        return getEngineCopy(this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(this.wheels);
        newList.add(newWheel);
        return new Car(this.year, this.color, newList, this.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car current = (Car) o;
        return Objects.equals(current.year, this.year)
                && Objects.equals(current.color, this.color)
                && Objects.equals(current.wheels, this.wheels)
                && Objects.equals(current.engine, this.engine);
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

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>(wheels.size());
        for (Wheel wheelData : wheels) {
            newList.add(wheelData.clone());
        }
        return newList;
    }

    private Engine getEngineCopy(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }
}

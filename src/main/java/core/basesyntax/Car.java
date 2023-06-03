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
        this.wheels = getDeepCopy(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getDeepCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
    //implement this class

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

    public List<Wheel> getDeepCopy(List<Wheel> wheels) {
        List<Wheel> copyOfList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyOfList.add(wheel.clone());
        }
        return copyOfList;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>(wheels);
        list.add(newWheel);
        return new Car(year, color, list, engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getDeepCopy(wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getDeepCopy(wheels), engine.clone());
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Impossible to create a clone", e);
        }
    }
}

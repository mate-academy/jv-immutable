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
        this.wheels = getCopyOfWheels(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyOfWheels(wheels), engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getCopyOfWheels(wheels), newEngine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>(wheels);
        list.add(newWheel);
        return new Car(year, color, list, engine);
    }

    private List<Wheel> getCopyOfWheels(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel : list) {
            newList.add(wheel.clone());
        }
        return newList;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car carInstance = (Car) obj;
        return carInstance.year == year
                && Objects.equals(carInstance.color, color)
                && Objects.equals(carInstance.wheels, wheels)
                && Objects.equals(carInstance.engine, engine);
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

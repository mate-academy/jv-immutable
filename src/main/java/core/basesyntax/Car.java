package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsList = new ArrayList<>();
        for (Wheel i: wheels) {
            wheelsList.add(i.clone());
        }
        return wheelsList;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsList = new ArrayList<>();
        for (Wheel i: wheels) {
            wheelsList.add(i.clone());
        }
        wheelsList.add(newWheel);
        return new Car(getYear(), getColor(), wheelsList, getEngine());
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
        Car car = (Car) obj;
        return year == car.year && color.equals(car.color) && car.engine.equals(engine)
                && car.wheels.equals(wheels);
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

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> wheelsList = new ArrayList<>();
        for (Wheel i: wheels) {
            wheelsList.add(i.clone());
        }
        return wheelsList;
    }
}

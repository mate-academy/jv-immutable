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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfList(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>();
        list.addAll(wheels);
        list.add(newWheel);
        return new Car(this.year, this.color, list, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.getWheels(), this.engine);
    }

    private List<Wheel> getCopyOfList(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (int i = 0; i < wheels.size(); i++) {
            list.add(wheels.get(i).clone());
        }
        return list;
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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Object clone() {
        return new Object();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car testCar = (Car) obj;
        return year == testCar.year
                && Objects.equals(color, testCar.color)
                && Objects.equals(wheels, testCar.wheels)
                && Objects.equals(engine, testCar.engine);
    }
}

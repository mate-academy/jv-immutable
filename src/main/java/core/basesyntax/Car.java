package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheelList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    private List<Wheel> cloneWheelList(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        return new Car(year, color, cloneWheelList(wheels), getEngine());
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color='" + color
                + '\'' + ", wheels=" + wheels + ", engine=" + engine + '}';
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, getWheels(), otherMaker);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheelList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> clonedWheels = cloneWheelList(wheels);
        clonedWheels.add(wheel);
        return new Car(year, color, clonedWheels, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), getEngine());
    }
}

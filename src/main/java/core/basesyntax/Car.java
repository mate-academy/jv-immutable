package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        this.engine = engine.clone();
        this.wheels = new ArrayList<>(wheels.size());
        this.wheels.addAll(wheels);
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return getCopyWheelList();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> wheels = getCopyWheelList();
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyWheelList(), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels = getCopyWheelList();
        wheels.add(newWheel);
        return new Car(year, color, wheels, engine.clone());
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
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    private List<Wheel> getCopyWheelList() {
        List<Wheel> wheels = new ArrayList<>(this.wheels.size());
        wheels.addAll(this.wheels);
        return wheels;
    }
}

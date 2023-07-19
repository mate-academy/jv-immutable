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
        this.wheels = getCopyWheel(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return getCopyWheel(wheels);
    }

    private List<Wheel> getCopyWheel(List<Wheel> wheelsList) {
        List<Wheel> wheelsCopyList = new ArrayList<>(wheelsList.size());
        for (Wheel wheel : wheelsList) {
            wheelsCopyList.add(wheel.clone());
        }
        return wheelsCopyList;
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = new ArrayList<>(wheels);
        newWheel.add(wheel);
        return new Car(year, color, newWheel, engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, color, wheels);
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
        return Objects.equals(engine, car.engine)
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels);
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
}

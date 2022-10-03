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
        this.wheels = getCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
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

    private static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> getCopyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            getCopyWheels.add(wheel.clone());
        }
        return getCopyWheels;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> addWheels = new ArrayList<>(wheels);
        addWheels.add(wheel);
        return new Car(this.year, this.color, addWheels, getEngine());
    }

    public Car changeColor(String white) {
        return new Car(this.year, white, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, getWheels(), engine);
    }
}

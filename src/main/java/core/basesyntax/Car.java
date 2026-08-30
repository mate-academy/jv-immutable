package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Make this class immutable. See requirements in task description. */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = deepCopyWheel(wheels);
        this.engine = deepCopyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine.getHorsePower() == 0 && engine.getManufacturer() == null) {
            return null;
        } else {
            return engine.clone();
        }
    }

    public List<Wheel> getWheels() {
        return deepCopyWheel(wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = deepCopyWheel(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> deepCopyWheel(List<Wheel> wheels) {
        List<Wheel> cloneWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }

    private Engine deepCopyEngine(Engine engine) {
        return engine == null ? new Engine(0, null) : engine.clone();
    }
    // implement this class

    @Override
    public String toString() {
        return "Car{"
                + "year="
                + year
                + ", color='"
                + color
                + '\''
                + ", wheels="
                + wheels
                + ", engine="
                + engine
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
}

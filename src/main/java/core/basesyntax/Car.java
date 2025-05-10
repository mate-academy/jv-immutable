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
        // Deep cloning
        this.wheels = deepCopyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(wheels);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = deepCopyWheels(wheels);
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine.clone());
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

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
    }
}

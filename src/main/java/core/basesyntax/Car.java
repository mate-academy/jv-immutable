package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 *
 * Class should be declared as final so it can’t be extended.
 * Make all fields private final
 * so the direct access is not allowed and field value can be assigned only once.
 * Your class can't have setter methods for fields.
 * Initialize all fields via a constructor, setting to a field a deep copy of input value.
 * In getters you should return deep copy instead of a simple reference to the objects field.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelsDeepCopy(wheels);
        this.engine = getEngineDeepCopy(engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), getEngineDeepCopy(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> allWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            allWheels.add(wheel.clone());
        }
        return allWheels;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    private Engine getEngineDeepCopy(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    private List<Wheel> getWheelsDeepCopy(List<Wheel> wheels) {
        List<Wheel> allWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            allWheels.add(wheel.clone());
        }
        return allWheels;
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
}

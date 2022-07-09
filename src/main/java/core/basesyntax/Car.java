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
        this.wheels = deepCopy(wheels);
        this.engine = engine == null ? null: new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return deepCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor()) && Objects.equals(getWheels(), car.getWheels()) && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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

    public Car changeEngine(Engine engine) {
        return new Car(this.year, getColor(), getWheels(), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(wheel);
        return new Car(this.year, getColor(), newWheels, getEngine());
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, getWheels(), getEngine());
    }

    private List<Wheel> deepCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }
}

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
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        this.wheels = copyWheels;
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        Engine newEngine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        return new Car(this.getYear(), this.getColor(), this.getWheels(), newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.getYear(), newColor, this.getWheels(), this.getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(this.getYear(), this.getColor(), newWheels, this.getEngine());
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
        return getYear() == car.getYear()
                && getColor().equals(car.getColor())
                && getWheels().equals(car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
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
}

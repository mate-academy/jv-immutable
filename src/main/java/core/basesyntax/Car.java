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
        this.engine = engine == null ? null : engine.clone();
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels = getWheels();
        wheels.add(newWheel);
        return new Car(getYear(), getColor(), wheels, getEngine());
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloneWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }

    public Engine getEngine() {
        return this.engine == null ? null : this.engine.clone();
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
        return getYear() == car.getYear() && getColor().equals(car.getColor())
                && getWheels().equals(car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getWheels().hashCode();
        result = 31 * result + getEngine().hashCode();
        return result;
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

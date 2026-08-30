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
        List newWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            newWheels.add(wheels.get(i).clone());
        }
        this.wheels = newWheels;
        this.engine = engine == null ? null : engine.clone();

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
        return getYear() == car.getYear() && Objects.equals(getColor(),
                car.getColor()) && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List newWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            newWheels.add(wheels.get(i).clone());
        }
        return newWheels;
    }

    public Engine getEngine() {

        return engine == null ? null : engine.clone();
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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("method clone not supported", e);
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = getWheels();
        wheelsCopy.add(newWheel);
        return new Car(year, color, wheelsCopy, getEngine());

    }
}

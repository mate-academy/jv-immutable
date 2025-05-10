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
        this.wheels = getCopy(wheels);
        if (engine == null) {
            this.engine = null;
            return;
        }
        this.engine = engine.clone();
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
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
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
        return getCopy(wheels);
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);

    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsAdded = getCopy(getWheels());
        wheelsAdded.add(newWheel);
        return new Car(year, color, wheelsAdded, engine);
    }

    public static List<Wheel> getCopy(List<Wheel> list) {
        List<Wheel> wheelCopy = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }
}

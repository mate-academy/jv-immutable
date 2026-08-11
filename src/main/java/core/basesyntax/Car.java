package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
        this.color = (color == null) ? "" : color;
        if (wheels == null) {
            throw new NullPointerException("Wheels is null!");
        }
        this.wheels = cloneWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    //implement this class
    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, getEngine());
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clone.add(wheel.clone());
        }
        return clone;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && myEquals(color, car.color)
                && myEquals(wheels, car.wheels)
                && myEquals(engine, car.engine);
    }

    public static boolean myEquals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }
}

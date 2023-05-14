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

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
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

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(getYear(), getColor(), newWheels, getEngine());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!object.getClass().equals(Car.class)) {
            return false;
        }
        Car other = (Car) object;
        boolean yearEquals = year == other.getYear();
        boolean colorEquals = color == null && other.getColor() == null
                || areObjectsEqual(color, other.getColor());
        boolean engineEquals = areObjectsEqual(engine, other.getEngine());
        boolean wheelsEquals;
        if (wheels == other.getWheels()) {
            wheelsEquals = true;
        } else if (wheels != null && wheels.size() == other.getWheels().size()) {
            wheelsEquals = true;
            for (int i = 0; i < wheels.size(); i++) {
                if (!areObjectsEqual(wheels.get(i), other.getWheels().get(i))) {
                    wheelsEquals = false;
                }
            }
        } else {
            wheelsEquals = false;
        }
        return yearEquals && colorEquals && engineEquals && wheelsEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        if (wheels != null) {
            for (Wheel wheel : wheels) {
                result = 31 * result + (wheel == null ? 0 : wheel.hashCode());
            }
        } else {
            result *= 31;
        }
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

    private <T> boolean areObjectsEqual(T a, T b) {
        return a == b || a != null && a.equals(b);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel item : wheels) {
            clonedWheels.add(item == null ? null : item.clone());
        }
        return clonedWheels;
    }
}

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
        this.wheels = deepCopyWheels(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return (engine == null ? null : engine.clone());
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
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        wheelsCopy.add(newWheel);
        return new Car(year, color, wheelsCopy, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            boolean wheelsEquals = this.wheels.size() == current.wheels.size();
            for (int i = 0; i < wheels.size(); i++) {
                wheelsEquals = wheelsEquals && this.wheels.get(i).equals(current.wheels.get(i));
            }
            return this.year == current.year &&
                    this.color.equals(current.color) &&
                    this.engine.equals(current.engine) &&
                    wheelsEquals;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        for (Wheel wheel : wheels) {
            result = 31 * result + (wheel == null ? 0 : wheel.hashCode());
        }
        return result;
    }

    public List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

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
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        this.wheels = wheelsCopy;
        this.engine = (engine == null) ? null: engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (year != car.year) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (wheels != null ? !wheels.equals(car.wheels) : car.wheels != null) return false;
        return engine != null ? engine.equals(car.engine) : car.engine == null;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
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
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }
//////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Each of these requirements should be fulfilled while designing an immutable class:
     * - Class should be declared as final so it can’t be extended.
     * - Make all fields private final so the direct access is not allowed and field value can be assigned only once.
     * - Your class can’t have setter methods for fields.
     * - Initialize all fields via a constructor, setting to a field a deep copy of input value.
     * - In getters you should return deep copy instead of a simple reference to the objects field.
     */
//////////////////////////////////////////////////////////////////////////////////////////////////
    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size() + 1);
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        wheelsCopy.add(newWheel);
        return new Car(this.year, this.color, wheelsCopy, this.engine);
    }
}

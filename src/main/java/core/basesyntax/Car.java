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
        this.wheels = getCopy(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }

        if (car == null) {
            return false;
        }

        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year && this.color.equals(current.color)
                    && this.wheels.equals(current.wheels)
                    && this.engine.equals(current.engine);
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
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

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        return this.engine != null ? this.engine.clone() : null;
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> listOfWheels = this.getCopy(wheels);
        listOfWheels.add(newWheel);
        return new Car(this.year, this.color, listOfWheels, this.engine);
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

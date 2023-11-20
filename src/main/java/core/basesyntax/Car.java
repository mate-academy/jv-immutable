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
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public List<Wheel> getWheels() {
        return getCopy(this.wheels);
    }

    public Engine getEngine() {
        return (this.engine != null) ? this.engine.clone() : null;
    }

    //implement this class
    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getCopy(this.wheels);
        newWheels.add(newWheel.clone());
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    @Override
    public boolean equals(Object car) {
        if (car == null) {
            return false;
        }
        if (car == this) {
            return true;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year
                    && this.color.equals(current.color)
                    && this.wheels.equals(current.wheels)
                    && this.engine.equals(current.engine);
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }
}

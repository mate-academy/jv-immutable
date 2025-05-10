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
        this.wheels = getWheelsClone(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine.clone());
    }

    public boolean equals(Object car) {
        if (car == null || car.getClass() != this.getClass()) {
            return false;
        }
        Car newCar = (Car) car;
        if (this == car) {
            return true;
        }
        return year == newCar.getYear()
                && color.equals(newCar.getColor())
                && wheels.equals(newCar.getWheels())
                && engine.equals(newCar.getEngine());
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode += hashCode * year;
        hashCode += hashCode * color.hashCode();
        hashCode += hashCode * wheels.hashCode();
        hashCode += hashCode * engine.hashCode();
        return hashCode;
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

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getWheelsClone(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }
}

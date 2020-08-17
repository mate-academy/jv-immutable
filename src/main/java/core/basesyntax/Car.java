package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getNewWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getNewWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> getNewWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
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
        return year == car.year
                && color == car.color || (color.equals(car.getColor()))
                && wheels == car.wheels || (wheels.equals(car.getWheels()))
                && engine == car.engine || (engine.equals(car.getEngine()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= 31 + year;
        result *= 31 + (color != null ? color.hashCode() : 0);
        result *= 31 + (wheels != null ? wheels.hashCode() : 0);
        result *= 31 + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}

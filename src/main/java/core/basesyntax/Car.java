package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyWheels(wheels);
        this.engine = copyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public Car changeYear(int year) {
        return new Car(year, color, wheels, engine);
    }

    public String getColor() {
        return color;
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = copyWheels(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
    }

    public Engine getEngine() {
        return copyEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Car car = (Car) other;
        return ((engine == car.engine || (engine != null && engine.equals(car.engine)))
                && (wheels == car.wheels || (wheels != null && wheels.equals(car.wheels)))
                && (color == car.color || (color != null && color.equals(car.color)))
                && year == car.year);
    }

    @Override
    public int hashCode() {
        int result = year;
        int prime = 41;
        result = prime * result + (color != null ? color.hashCode() : 0);
        result = prime * result + (wheels != null ? wheels.hashCode() : 0);
        result = prime * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel oneWheel : wheels) {
            newWheels.add(oneWheel.clone());
        }
        return newWheels;
    }

    private Engine copyEngine(Engine engine) {
        return (engine == null) ? null : engine.clone();
    }
}

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
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel oneWheel : wheels) {
            newWheels.add(oneWheel.clone());
        }
        this.wheels = newWheels;
        this.engine = (engine == null) ? null : new Engine(engine.getHorsePower(), engine.getMaker());
    }

    public int getYear() {
        return year;
    }

    public Car changeYear(int year) {
        return new Car(year, color, new ArrayList<>(wheels), new Engine(engine.getHorsePower(), engine.getMaker()));
    }

    public String getColor() {
        return color;
    }

    public Car changeColor(String color) {
        return new Car(year, color, new ArrayList<>(wheels), new Engine(engine.getHorsePower(), engine.getMaker()));
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, new Engine(engine.getHorsePower(), engine.getMaker()));
    }

    public Engine getEngine() {
        return (engine == null) ? null : new Engine(engine.getHorsePower(), engine.getMaker());
    }

    public Car changeEngine(Engine engine) {
        Engine newEngine = engine;
        return new Car(year, color, new ArrayList<>(wheels), newEngine);
    }

    @Override
    public Car clone() {
        return new Car(year, color, new ArrayList<>(wheels), engine.clone());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Car car = (Car) other;
        if (year != car.year) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        if (wheels != null ? !wheels.equals(car.wheels) : car.wheels != null) return false;
        return engine != null ? engine.equals(car.engine) : car.engine == null;
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
}

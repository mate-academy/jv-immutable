package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Make this class immutable. See requirements in task description.
 */

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel.getRadius()));
        }
        this.engine = engine != null ?
                new Engine(engine.getHorsePower(), engine.getManufacturer()) : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> improvedWheels = new ArrayList<>(this.wheels);
        improvedWheels.add(newWheel);
        return new Car(this.year,this.color, improvedWheels, this.engine);
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public Engine getEngine() {
        return this.engine != null ?
                new Engine(this.engine.getHorsePower(), this.engine.getManufacturer()) : null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    @Override
    protected Car clone() {
        Car clone = null;
        try {
            clone = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone this car: " + e);
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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
}

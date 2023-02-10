package core.basesyntax;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.color = color == null ? null : new String(color);
        this.wheels = new ArrayList<Wheel>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel.getRadius()));
        }
        this.engine = engine == null ? null :engine.clone();
    }

    public Car(Car car) {
        this.year = car.year;
        this.color = new String(car.color);
        this.wheels = new ArrayList<>(car.wheels);
        this.engine = new Engine(car.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> returnedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            returnedWheels.add(new Wheel(wheel.getRadius()));
        }
        return returnedWheels;
    }

    public Engine getEngine() {
        return engine == null ? null :new Engine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        this.wheels.add(wheel);
        return new Car(this.year, this.color, this.wheels, this.engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
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

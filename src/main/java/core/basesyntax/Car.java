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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        if (color != null) {
            this.color = color;
        } else {
            this.color = null;
        }
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            Wheel wheel1 = new Wheel(wheel.getRadius());
            copy.add(wheel1);
        }
        this.wheels = new ArrayList<>(copy);
        if (engine != null) {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        if (this.color == null) {
            return null;
        }
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopy = new ArrayList<>();
        for (Wheel currentWheel : wheels) {
            deepCopy.add(new Wheel(currentWheel.getRadius()));
        }
        return deepCopy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine otherMaker) {
        return null;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel2 : wheels) {
            newList.add(new Wheel(wheel2.getRadius()));
        }
        Wheel wheel1 = new Wheel(wheel.getRadius());
        newList.add(wheel1);
        return new Car(this.year, this.color, newList, this.engine);
    }

    public Car changeColor(String someColor) {
        return new Car(this.year, someColor, this.wheels, this.engine);
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
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        return new Car(year, color, getWheels(), engine);
    }
}

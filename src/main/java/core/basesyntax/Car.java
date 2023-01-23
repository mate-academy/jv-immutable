package core.basesyntax;

import java.util.LinkedList;
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

    public Car(int year, String color, List<Wheel> wheels, Engine engine)
            throws NullPointerException {
        this.year = year;
        this.color = color;
        List<Wheel> wheels1;
        try {
            wheels1 = new LinkedList<>();
            for (Wheel wheel : wheels) {
                (wheels1).add(new Wheel(wheel));
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Null" + e);
        }
        this.wheels = wheels1;
        Engine engine1 = null;
        if (engine != null) {
            engine1 = new Engine(engine);
        }
        this.engine = engine1;
    }

    public Car(Car car) {
        this.year = car.getYear();
        this.color = car.getColor();
        this.wheels = car.getWheels();
        this.engine = car.getEngine();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new LinkedList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(new Wheel(wheel));
        }
        return newWheels;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
    }

    public Engine getEngine() {
        return engine != null ? new Engine(engine) : null;
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

    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, wheels, otherMaker);
    }

    public Car changeColor(String blue) {
        return new Car(year, blue, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && color.equals(car.color)
                && wheels.equals(car.wheels)
                && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

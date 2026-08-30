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
    Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyOfCollection(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = copyOfCollection(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyOfCollection(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year && color.equals(car.color)
                && wheels.equals(car.wheels) && engine.equals(car.engine);
    }

    @Override
    public Car clone() {
        try {
            return new Car(year, color, copyOfCollection(wheels), engine.clone());
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't create copy of Car", e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> copyOfCollection(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }

}

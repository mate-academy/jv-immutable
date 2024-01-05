package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
        this.color = color;
        this.wheels = getWheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheelsCopy(List<Wheel> listWheels) {
        List<Wheel> wheelCopy = new ArrayList<>(listWheels.size());
        for (Wheel wheel : listWheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(getYear(), getColor(), getWheels(), otherMaker);
    }

    String getColor() {
        return color;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> clonedWheels = getWheels();
        clonedWheels.add(wheel);
        return new Car(getYear(), getColor(), clonedWheels, getEngine());
    }

    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Car object", e);
        }
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
        if (year != car.year) {
            return false;
        }
        if (!color.equals(car.color)) {
            return false;
        }
        if (!wheels.equals(car.wheels)) {
            return false;
        }
        return engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", engine=" + engine
                + ", wheels=" + wheels
                + '}';
    }
}

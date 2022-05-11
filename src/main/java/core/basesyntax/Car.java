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
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        this.wheels = wheelsCopy;
        this.engine = engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels);
        wheelsCopy.add(wheel);
        return new Car(year, color, wheelsCopy, engine);
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(getYear(), getColor(), getWheels(), otherMaker);
    }

    public Car changeColor(String blue) {
        return new Car(getYear(), blue, getWheels(), getEngine());
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (!(car instanceof Car)) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car otherCar = (Car) car;
            boolean yearEquals = (year == 0 && otherCar.year == 0)
                    || (year != 0 && otherCar.year != 0
                    && year == otherCar.year);
            boolean colorEquals = (color == null && otherCar.color == null)
                    || (color != null && otherCar.color != null
                    && color.equals(otherCar.color));
            boolean wheelsEquals = (wheels == null && otherCar.wheels == null)
                    || (wheels != null && otherCar.wheels != null
                    && wheels.equals(otherCar.wheels));
            boolean engineEquals = (engine == null && otherCar.engine == null)
                    || (engine != null && otherCar.engine != null
                    && engine.equals(otherCar.engine));
            return yearEquals && colorEquals && wheelsEquals && engineEquals;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        if (year != 0) {
            result = prime * result + year;
        }
        if (color != null) {
            result = prime * result + color.hashCode();
        }
        if (wheels != null) {
            result = prime * result + wheels.hashCode();
        }
        if (engine != null) {
            result = prime * result + engine.hashCode();
        }
        return result;
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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone Car", e);
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
}

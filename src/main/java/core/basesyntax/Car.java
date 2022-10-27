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
        this.wheels = copyWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        if (this.engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, copyWheels(this.wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, copyWheels(this.wheels), this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = copyWheels(wheels);
        list.add(newWheel);
        return new Car(this.year, this.color, list, this.engine.clone());
    }

    @Override
    protected Object clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 17 * result + year;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        result = 17 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 17 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        } else if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car c = (Car) car;
            return c.year == this.year && c.color.equals(this.color) && c.wheels.equals(this.wheels)
                    && c.engine.equals(this.engine);
        }
        return false;
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

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> list;
        try {
            list = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                list.add((Wheel)wheel.clone());
            }
            //list.addAll(wheels);
        } catch (RuntimeException e) {
            throw new NullPointerException();
        }
        return list;
    }
}

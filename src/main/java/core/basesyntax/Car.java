package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (wheels == null) {
            return null;
        } else {
            return getCopy(wheels);
        }
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }

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
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public int hashCode() {
        int primeNumber = 17;
        primeNumber = 31 * primeNumber + year;
        primeNumber = 31 * primeNumber + (color == null ? 0 : color.hashCode());
        primeNumber = 31 * primeNumber + (wheels == null ? 0 : wheels.hashCode());
        primeNumber = 31 * primeNumber + (engine == null ? 0 : engine.hashCode());
        return primeNumber;
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null || getClass() != car.getClass()) {
            return false;
        }
        Car current = (Car) car;
        return this.year == current.year
                && (this.color == current.color
                || (this.color != null && this.color.equals(current.color)))
                && (this.wheels == current.wheels
                || (this.wheels != null && this.wheels.equals(current.wheels)))
                && (this.engine == current.engine
                || (this.engine != null && this.engine.equals(current.engine)));
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        if (wheels == null) {
            throw new NullPointerException("wheels is NULL");
        }
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            throw new NullPointerException("Object Wheel is null");
        }
        List<Wheel> newListOfWheels = getCopy(wheels);
        newListOfWheels.add(newWheel);
        return new Car(year, color, newListOfWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

}

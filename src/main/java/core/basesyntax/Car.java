package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        ArrayList<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        this.wheels = list;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Wheel> getWheels() {
        ArrayList<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    @Override
    public boolean equals(Object car) {
        if (car == null) {
            return false;
        }
        if (this == car) {
            return true;
        }
        if (!this.getClass().equals(car.getClass())) {
            return false;
        }
        Car current = (Car) car;
        if (this.year != current.year) {
            return false;
        } else if (!this.color.equals(current.color)) {
            return false;
        } else if (!this.wheels.equals(current.wheels)) {
            return false;
        } else {
            return this.engine.equals(current.engine);
        }
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + year;
        h = 31 * h + ((color == null) ? 0 : color.hashCode());
        h = 31 * h + ((wheels == null) ? 0 : wheels.hashCode());
        return 31 * h + ((engine == null) ? 0 : engine.hashCode());
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        ArrayList<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
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

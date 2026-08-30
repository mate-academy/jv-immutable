package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels = new ArrayList<>();
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine != null) {
            this.engine = new Engine(engine);
        } else {
            this.engine = null;
        }
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels = new ArrayList<>(this.wheels);
        wheels.add(newWheel.clone());
        return new Car(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
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

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car car = (Car) obj;

        return car.color.equals(this.color)
                && car.wheels.equals(this.wheels)
                && car.engine.equals(this.engine)
                && this.year == car.year;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + year;
        hash = 37 * hash + (color == null ? 0 : color.hashCode());
        hash = 37 * hash + wheels.hashCode();
        hash = 37 * hash + (engine == null ? 0 : engine.hashCode());
        return hash;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone car", e);
        }
    }
}

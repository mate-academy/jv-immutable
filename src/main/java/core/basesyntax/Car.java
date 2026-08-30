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
        this.engine = engine == null ? null : engine.clone();

        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel w : wheels) {
            wheelsCopy.add(w.clone());
        }
        this.wheels = wheelsCopy;
    }

    //implement this class

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(w.clone());
        }
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car current = (Car) o;

        if (color != null ? !color.equals(current.color) : current.color != null) {
            return false;
        }
        if (engine != null ? !engine.equals(current.engine) : current.engine != null) {
            return false;
        }
        if (wheels != null ? !wheels.equals(current.wheels) : current.wheels != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (color == null ? 0 : color.hashCode());
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

    public String getColor() {
        return color;
    }
}

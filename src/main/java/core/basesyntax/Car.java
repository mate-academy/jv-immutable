package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> cloned = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            cloned.add(wheel.clone());
        }
        this.wheels = cloned;
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloned = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            cloned.add(wheel.clone());
        }
        return cloned;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime * year;
        result = result * prime * ((color == null) ? 0 : color.hashCode());
        result = result * prime * ((wheels == null) ? 0 : wheels.hashCode());
        result = result * prime * ((engine == null) ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass().equals(obj.getClass()) && this.hashCode() == obj.hashCode()) {
            Car current = (Car) obj;
            return year == current.year && color.equals(current.color)
                    && wheels == current.wheels || wheels != null
                    && wheels.equals(current.getWheels()) && engine == current.engine
                    || engine != null && engine.equals(current.getEngine());
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
}

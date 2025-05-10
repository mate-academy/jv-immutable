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
        this.wheels = clonedWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            return this.year == current.year && this.color == current.color
                    || this.color != null && this.color.equals(current.color)
                    && this.wheels == current.wheels || this.wheels != null
                    && this.wheels.equals(current.wheels) && this.engine == current.engine
                    || this.engine != null && this.engine.equals(current.engine);

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

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = getWheels();
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
    }

    private List<Wheel> clonedWheels(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return clonedWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
}

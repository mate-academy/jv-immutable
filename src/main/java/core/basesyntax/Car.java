package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        this.wheels = list;
        this.engine = engine == null ? null : engine.clone();
    }

    Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels == null ? null : cloneListOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(wheels);
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
    }

    List<Wheel> cloneListOfWheels(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (color == null ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            return Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine)
                    && Objects.equals(this.color, current.color)
                    && this.year == current.year;
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

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.wheels = cloneWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = engine;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = cloneWheels(wheels);
        newList.add(newWheel);

        return new Car(year,color,newList,getEngine());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private List<Wheel> cloneWheels(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        if (this.engine != null) {
            return engine.clone();
        } else {
            return this.engine;
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
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) {
            return false;
        }
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        return new Car(year,color,getWheels(),getEngine());
    }
}

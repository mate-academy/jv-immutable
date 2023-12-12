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
        this.wheels = getWheelsClone(wheels);
        this.engine = getEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(this.wheels);
    }

    public List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList();
        for (Wheel wheel: wheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    public Engine getEngine() {
        return getEngineClone(this.engine);
    }

    public Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
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
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newList.add(wheel);
        }
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if ((year != car.year) || (!Objects.equals(color, car.color))
                || (!Objects.equals(wheels, car.wheels))) {
            return false;
        }
        return Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return new Car(year, color, getWheels(), getEngine());
    }
}

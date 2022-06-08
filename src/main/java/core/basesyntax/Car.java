package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable{
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        return new Car(year, color, copyList(wheels, newWheel), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyList(wheels), engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, copyList(wheels), engine.clone());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return getYear() == car.getYear()
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Couldn't clone the car", e);
        }
    }

    private List<Wheel> copyList (List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    private List<Wheel> copyList (List<Wheel> wheels, Wheel wheel) {
        List<Wheel> newList = copyList(wheels);
        newList.add(wheel.clone());
        return newList;
    }
}

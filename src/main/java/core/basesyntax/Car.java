package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements CarChanger {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getListClone(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getListClone(wheels);
    }

    public Engine getEngine() {
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

    @Override
    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    @Override
    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    @Override
    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = getWheels();
        list.add(newWheel);
        return new Car(getYear(), getColor(), list, getEngine());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> getListClone(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>(list.size());
        for (Wheel element : list) {
            newList.add(element == null ? null : element.clone());
        }
        return newList;
    }
}

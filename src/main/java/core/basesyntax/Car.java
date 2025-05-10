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
        this.wheels = new ArrayList<>(getDeepCopy(wheels));
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return getDeepCopy(wheels);
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> getDeepCopy(List<Wheel> wheels) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    public Car changeEngine(Engine engine) {
        Car carCopy = new Car(year, color, wheels, engine);
        return carCopy;
    }

    public Car changeColor(String newColor) {
        Car carCopy = new Car(year, newColor, wheels, engine);
        return carCopy;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = getDeepCopy(wheels);
        newWheelList.add(newWheel);
        Car carCopy = new Car(year, color, newWheelList, engine);
        return carCopy;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

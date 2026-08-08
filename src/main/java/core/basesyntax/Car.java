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
        this.wheels = deepCopy(wheels);
        this.engine = copyOf(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, deepCopy(wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, deepCopy(wheels), copyOf(engine));
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheelList = deepCopy(wheels);
        newWheelList.add(wheel);
        return new Car(year, color, newWheelList, copyOf(engine));
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopy(wheels);
    }

    public Engine getEngine() {
        return copyOf(engine);
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

    private List<Wheel> deepCopy(List<Wheel> list) {
        List<Wheel> listCopy = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            listCopy.add(wheel.clone());
        }
        return listCopy;
    }

    private Engine copyOf(Engine engine) {
        return engine == null ? null : engine.clone();
    }

}

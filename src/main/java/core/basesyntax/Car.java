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
        this.wheels = deepCopyOfWheels(wheels);
        this.engine = deepCopyOfEngine(engine);
    }

    private Engine deepCopyOfEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyOfWheels(wheels);
    }

    private List<Wheel> deepCopyOfWheels(List<Wheel> wheelList) {
        List<Wheel> copyOfList = new ArrayList<>(wheelList.size());
        for (Wheel listElement : wheelList) {
            copyOfList.add(listElement.clone());
        }
        return copyOfList;
    }

    public Engine getEngine() {
        return deepCopyOfEngine(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelList = deepCopyOfWheels(wheels);
        wheelList.add(wheel);
        return new Car(year, color, wheelList, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }
}

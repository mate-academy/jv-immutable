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
        this.wheels = getCopy(wheels);
        this.engine = engine != null ? engine.clone() : null;
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

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeColor(String newColor) {

        return new Car(year, newColor, getCopy(wheels), engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getCopy(wheels), engine.clone());
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = getCopy(wheels);
        newWheel.add(wheel.clone());
        return new Car(year, color, newWheel, engine.clone());
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    private static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

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
        this.wheels = wheelCloned(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelCloned(wheels);
    }

    public Engine getEngine() {
        return engineCloned(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    private static List<Wheel> wheelCloned(List<Wheel> wheels) {
        List<Wheel> wheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    private Engine engineCloned(Engine engine) {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(wheel.clone());
        return car;

    }

    public Car changeColor(String color) {
        Car car = new Car(year, color, wheels, engine);
        return car;
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
        return ((year == car.year) && (color == car.color
                || color != null && color.equals(car.color))
                && (wheels == wheels || wheels != null
                && wheels.equals(car.wheels))
                && (engine == car.engine || engine != null
                && engine.equals(car.engine)));
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + year;
        result = result * 17 + (color == null ? null : color.hashCode());
        result = result * 17 + (wheels == null ? null : wheels.hashCode());
        result = result * 17 + (engine == null ? null : engine.hashCode());
        return result;
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

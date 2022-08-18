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
        this.wheels = copyListWheels(wheels);
        this.engine = copyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return copyEngine(engine);
    }

    public List<Wheel> getWheels() {
        return copyListWheels(wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, copyListWheels(wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyListWheels(wheels), copyEngine(engine));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = copyListWheels(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine.clone());
    }

    private Engine copyEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> copyListWheels(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
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

    //implement this class

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

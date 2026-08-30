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
        this.wheels = getCopyWheel(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheel(wheels);
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
        int result = 1;
        result = 17 * result + year;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        result = 17 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 17 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, wheels, otherMaker);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelCopy = getCopyWheel(wheels);
        wheelCopy.add(wheel);
        return new Car(year, color, wheelCopy, engine);
    }

    public Car changeColor(String blue) {
        return new Car(year, blue, wheels, engine);
    }

    private List<Wheel> getCopyWheel(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

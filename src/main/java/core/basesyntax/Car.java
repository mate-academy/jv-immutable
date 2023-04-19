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
        this.color = color == null ? null : color;
        this.wheels = getNewWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getNewWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        return car != null
                && this.getClass() == car.getClass()
                && this.engine.equals(car.engine)
                && this.color.equals(car.color)
                && this.wheels.equals(car.wheels)
                && this.year == car.year;
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

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> getNewWheels(List<Wheel> oldWheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : oldWheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }
}

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
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);///
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyWheels(wheels), engine.clone()); ///
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = null;
        if (newWheel != null) {
            newWheels = getCopyWheels(wheels);
            newWheels.add(newWheel);
        }
        return new Car(year, color, newWheels, engine.clone()); ///
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            engine = this.engine;
        }
        return new Car(year, color, getCopyWheels(wheels), engine);///
    }

    public List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
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
        return getYear() == car.getYear() && Objects.equals(getColor(),
                car.getColor()) && Objects.equals(getWheels(),
                car.getWheels()) && Objects.equals(getEngine(),
                car.getEngine());
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
}

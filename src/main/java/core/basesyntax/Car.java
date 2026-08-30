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
        this.wheels = wheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = wheelsCopy(wheels);
        copyWheels.add(newWheel);
        return new Car(year, color, copyWheels, engine.clone());
    }

    public List<Wheel> wheelsCopy(List<Wheel> newWheels) {
        List<Wheel> allWheels = new ArrayList<>();
        for (Wheel wheel : newWheels) {
            allWheels.add(wheel.clone());
        }
        return allWheels;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Car newCar = (Car) obj;
        return year == newCar.year && Objects.equals(color, newCar.color)
                && Objects.equals(wheels, newCar.wheels) && Objects.equals(engine, newCar.engine);
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

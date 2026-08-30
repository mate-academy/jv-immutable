package core.basesyntax;

import java.util.ArrayList;
import java.util.Iterator;
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
        this.wheels = cloneWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        String d = null;
        return new Car(year, color, newWheels, engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Car.class)) {
            Car car = (Car) o;
            return Objects.equals(this.year, car.year)
                    && Objects.equals(this.color, car.color)
                    && Objects.equals(this.wheels, car.wheels)
                    && Objects.equals(this.engine, car.engine);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash * 31 + year;
        hash = hash * 31 + (color != null ? color.hashCode() : 0);
        hash = hash * 31 + (color != null ? wheels.hashCode() : 0);
        hash = hash * 31 + (color != null ? engine.hashCode() : 0);
        return hash;
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        if (wheels == null) {
            throw new NullPointerException();
        }

        List<Wheel> copyWheels = new ArrayList<>();
        Iterator<Wheel> iterator = wheels.iterator();
        while (iterator.hasNext()) {
            copyWheels.add(iterator.next().clone());
        }
        return copyWheels;
    }
}

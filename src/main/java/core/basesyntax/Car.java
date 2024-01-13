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

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        this.wheels = getCopyWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }

    public List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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
        return year == car.year && color.equals(car.color)
                && wheels.equals(car.wheels) && engine.equals(car.engine);
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
}

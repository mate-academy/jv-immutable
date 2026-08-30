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
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getCopy(wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
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
        if (o == null) {
            return false;
        }
        if (o.getClass().equals(Car.class)) {
            Car car = (Car) o;
            return year == car.year && Objects.equals(this.color, car.color)
                    && wheels.equals(this.wheels) && Objects.equals(this.engine, car.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 17 + year;
        result = result * 17 + (color == null ? 0 : color.hashCode());
        result = result * 17 + (wheels == null ? 0 : wheels.hashCode());
        result = result * 17 + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    private static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }
}

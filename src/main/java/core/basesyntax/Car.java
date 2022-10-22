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
        List<Wheel> newWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        this.wheels = newWheel;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine);
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheel = new ArrayList<>(this.wheels);
        wheel.add(newWheel);
        return new Car(this.year, this.color, wheel, this.engine);
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        return newWheel;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine);
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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }
}

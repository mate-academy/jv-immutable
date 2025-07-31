package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(CarBuilder carBuilder) {
        year = carBuilder.year;
        color = carBuilder.color;
        wheels = carBuilder.wheels;
        engine = carBuilder.engine;
    }

    public static class CarBuilder {
        private final int year;
        private final String color;
        private final List<Wheel> wheels;
        private final Engine engine;

        public CarBuilder(int year, String color, List<Wheel> wheels, Engine engine) {
            this.year = year;
            this.color = color;
            this.wheels = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                this.wheels.add(wheel.clone());
            }
            this.engine = engine.clone();
        }
        public Car build() {
            return new Car(this);
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return engine.clone();
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

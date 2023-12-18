package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> deepCopyOfWheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel wheel : wheels) {
                deepCopyOfWheels.add(wheel.clone());
            }
        }
        this.wheels = deepCopyOfWheels;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
        if (wheels == null) {
            throw new NullPointerException();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopyOfWheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel wheel : wheels) {
                deepCopyOfWheels.add(wheel.clone());
            }
        }
        return deepCopyOfWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> deepCopyOfWheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel existingWheel : wheels) {
                deepCopyOfWheels.add(existingWheel.clone());
            }
        }
        deepCopyOfWheels.add(wheel);
        return new Car(this.year, this.color, deepCopyOfWheels, this.engine);
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

    @Override
    public String toString() {
        return "Car{" + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine + '}';
    }
}

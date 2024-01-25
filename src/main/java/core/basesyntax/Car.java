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

    public Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.engine = builder.engine.clone();
        this.wheels = getWheels();
    }

    //implement this class
    public Car changeEngine(Engine engine) {
        return new Car.Builder()
                .setYear(year)
                .setColor(color)
                .setWheels(wheels)
                .setEngine(engine.clone())
                .build();
    }

    public Car changeColor(String newColor) {
        return new Car.Builder()
                .setYear(year)
                .setColor(newColor)
                .setWheels(wheels)
                .setEngine(engine.clone())
                .build();
    }

    public void addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel.clone());
        this.wheels.clear();
        this.wheels.addAll(newWheels);
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels);
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
      return  engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
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
    public Car clone() {
        try {
        Car clonedCar = (Car) super.clone();
        clonedCar.changeEngine(engine.clone());
        return clonedCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Car not cloned", e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, wheels, engine);
    }

    private static class Builder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setWheels(List<Wheel> wheels) {
            this.wheels = new ArrayList<>(wheels);
            return this;
        }

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

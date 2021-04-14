package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> wheelList = new ArrayList<>();
        this.wheels = wheelList;
        for (Wheel item: wheels) {
            Wheel clonedItem = item.clone();
            wheelList.add(clonedItem);
        }
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = builder.wheels != null ? new ArrayList<>(builder.wheels) : null;
        this.engine = builder.engine != null ? builder.engine.clone() : null;
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

    static class Builder {
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
            this.wheels = wheels;
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car.Builder().setEngine(engine).build();
    }

    public Car changeColor(String newColor) {
        return new Car.Builder().setColor(newColor).build();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel item: wheels) {
            Wheel cloneItem = item.clone();
            wheelsCopy.add(cloneItem);
        }
        wheelsCopy.add(newWheel.clone());
        return new Car.Builder().setWheels(wheelsCopy).build();
    }
}

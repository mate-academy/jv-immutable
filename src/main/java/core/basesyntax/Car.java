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
        this.wheels = new ArrayList<>();
        this.year = year;
        this.color = color;
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = builder.wheels;
        this.engine = builder.engine;
    }

    public static class Builder {
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
        return this.wheels != null ? new ArrayList<>(wheels) : null;
    }

    public Engine getEngine() {
        return this.engine != null ? engine.clone() : null;
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

    public Car changeEngine(Engine engine) {
        return new Builder()
                .setEngine(engine)
                .setColor(color)
                .setWheels(wheels)
                .setYear(year)
                .build();
    }

    public Car changeColor(String newColor) {
        return new Builder()
                .setYear(year)
                .setColor(newColor)
                .setEngine(engine)
                .setWheels(wheels)
                .build();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(wheels);
        newList.add(newWheel);
        return new Builder()
                .setEngine(engine)
                .setColor(color)
                .setWheels(newList)
                .setYear(year)
                .build();
    }
}

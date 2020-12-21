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
        this.wheels = deepCopyOfWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    private Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = deepCopyOfWheels(builder.wheels);
        this.engine = builder != null ? builder.engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Builder()
                .setYear(year)
                .setColor(color)
                .setWheels(wheels)
                .setEngine(engine)
                .build();
    }

    public Car changeColor(String newColor) {
        return new Builder()
                .setYear(year)
                .setColor(newColor)
                .setWheels(wheels)
                .setEngine(engine)
                .build();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        newWheels.add(newWheel.clone());
        return new Builder()
                .setYear(year)
                .setColor(color)
                .setWheels(newWheels)
                .setEngine(engine)
                .build();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    private List<Wheel> deepCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

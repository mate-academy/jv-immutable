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
        this.wheels = copyWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = copyWheels(builder.wheels);
        this.engine = builder.engine != null ? builder.engine.clone() : null;
    }

    public static class Builder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder wheels(List<Wheel> wheels) {
            this.wheels = new ArrayList<>();
            if (wheels != null) {
                for (Wheel wheel : wheels) {
                    this.wheels.add(wheel.clone());
                }
            }
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine != null ? engine.clone() : null;
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
        return copyWheels(this.wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = copyWheels(this.wheels);
        newWheels.add(newWheel);
        return new Car.Builder().year(year).color(color).wheels(newWheels).engine(engine).build();
    }

    public Car changeColor(String newColor) {
        return new Car.Builder().year(year).color(newColor).wheels(wheels).engine(engine).build();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car.Builder().year(year).color(color).wheels(wheels).engine(newEngine).build();
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
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
            && Objects.equals(getWheels(), car.getWheels()) && Objects
            .equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    private static List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }
}

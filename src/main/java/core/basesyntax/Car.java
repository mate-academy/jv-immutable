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
        this.wheels = cloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = builder.wheels;
        this.engine = builder.engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o.getClass().equals(this.getClass()))) {
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

    public Car changeEngine(Engine newEngine) {
        Builder builder = new Builder();
        builder.setEngine(newEngine);
        return new Car(builder);
    }

    public Car changeColor(String newColor) {
        Builder builder = new Builder();
        builder.setColor(newColor);
        return new Car(builder);
    }

    public Car addWheel(Wheel newWheel) {
        Builder builder = new Builder();
        builder.wheels = cloneWheels(wheels);
        builder.wheels.add(newWheel);
        return new Car(builder);
    }

    private List<Wheel> cloneWheels(List<Wheel> list) {
        List<Wheel> assignWheels = new ArrayList<>();
        for (Wheel wheel : list) {
            assignWheels.add((Wheel) wheel.clone());
        }
        return assignWheels;
    }

    private class Builder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public Builder setWheels(List<Wheel> wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

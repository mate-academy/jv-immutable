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
        this.wheels = cloneListOfWheels(wheels);
        this.engine = getEngine(engine);
    }

    public Car(CarBuilder carBuilder) {
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.engine = getEngine(carBuilder.engine);
        this.wheels = cloneListOfWheels(carBuilder.wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneListOfWheels(wheels);
    }

    public Engine getEngine() {
        return getEngine(engine);
    }

    private Engine getEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car.CarBuilder()
                .setEngine(engine)
                .setColor(color)
                .setYear(year)
                .setWheels(wheels)
                .build();
    }

    public Car changeColor(String newColor) {
        return new Car.CarBuilder()
                .setEngine(engine)
                .setColor(newColor)
                .setYear(year)
                .setWheels(wheels)
                .build();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(wheels);
        newList.add(newWheel);
        return new Car.CarBuilder()
                .setEngine(engine)
                .setColor(color)
                .setYear(year)
                .setWheels(newList)
                .build();
    }

    public static final class CarBuilder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public CarBuilder() {
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setWheels(List<Wheel> wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
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

    private List<Wheel> cloneListOfWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel == null ? null : wheel.clone());
        }
        return clonedWheels;
    }
}

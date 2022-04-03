package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    private Car(CarBuilder carBuilder) {
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.wheels = carBuilder.wheels;
        this.engine = carBuilder.engine;
    }

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = getCopy(engine);
    }

    static class CarBuilder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setWheels(List<Wheel> wheels) {
            this.wheels = getCopy(wheels);
            return this;
        }

        public CarBuilder setEngine(Engine engine) {
            this.engine = engine.clone();
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private static Engine getCopy(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private static List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car changeEngine(Engine engine) {
        return new CarBuilder().setEngine(engine).build();
    }

    public Car changeColor(String newColor) {
        return new CarBuilder().setColor(newColor).build();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copy = new ArrayList<>(wheels.size() + 1);
        for (Wheel wheel : wheels) {
            copy.add(wheel);
        }
        copy.add(newWheel);
        return new CarBuilder().setWheels(copy).build();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
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

}

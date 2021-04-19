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
        this.wheels = cloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(wheel.clone());
        return car;
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
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>();
        for (Wheel currentWheel : wheels) {
            copyOfWheels.add(currentWheel.clone());
        }
        return copyOfWheels;
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
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}


















/*public static class Builder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public Builder(int year, String color, List<Wheel> wheels, Engine engine) {
            this.year = year;
            this.color = color;
            this.wheels = wheels;
            this.engine = engine;
        }

        public Builder setYear(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            //all if the checks are here
            return new Car(this);
        }
    }*/
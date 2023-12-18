package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
/**
 * Make this class immutable. See requirements in task description.
 */

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    private Car(CarBuilder carBuilder) {
        this.engine = carBuilder.engine;
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.wheels = carBuilder.wheels;
    }

    public Car changeEngine(Engine newEngine) {
        return new CarBuilder()
                .setColor(getColor())
                .setEngine(newEngine)
                .setYear(getYear())
                .setWheels(getWheels())
                .buildCar();
    }

    public Car changeColor(String newColor) {
        return new CarBuilder()
                .setColor(newColor)
                .setEngine(getEngine())
                .setYear(getYear())
                .setWheels(getWheels())
                .buildCar();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = getCopyWheels(this.wheels);
        wheelList.add(newWheel);
        return new CarBuilder()
                .setColor(getColor())
                .setEngine(getEngine())
                .setYear(getYear())
                .setWheels(wheelList)
                .buildCar();
    }

    @Override
    protected Car clone() {
        return new Car(year, color, getCopyWheels(wheels), this.engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> copyOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return engine;
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
        return year == car.year && (color == car.color || color != null && color.equals(car.color))
                && (wheels == car.wheels || wheels != null && wheels.equals(car.wheels))
                && (engine == car.engine || engine != null && engine.equals(car.engine));
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
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

    private static class CarBuilder {
        private int year;
        private String color;
        private List<Wheel> wheels;
        private Engine engine;

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
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

        public Car buildCar() {
            return new Car(this);
        }
    }
}

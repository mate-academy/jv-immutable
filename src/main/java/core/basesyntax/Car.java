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
    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelDeepCopy(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    private Car(CarBuilder carBuilder) {
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.wheels = carBuilder.wheels;
        this.engine = carBuilder.engine;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelDeepCopy(wheels);
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return engine;
    }

    public Car changeEngine(Engine newEngine) {
        return new CarBuilder()
                .setColor(this.color)
                .setYear(this.year)
                .setEngine(newEngine)
                .setWheels(getWheelDeepCopy(this.wheels))
                .buildCar();
    }

    public Car changeColor(String newColor) {
        return new CarBuilder()
                .setColor(newColor)
                .setYear(this.year)
                .setEngine(this.engine.clone())
                .setWheels(getWheelDeepCopy(this.wheels))
                .buildCar();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelDeepCopy = getWheelDeepCopy(this.wheels);
        wheelDeepCopy.add(newWheel);
        return new CarBuilder()
                .setColor(this.color)
                .setYear(this.year)
                .setEngine(this.engine.clone())
                .setWheels(wheelDeepCopy)
                .buildCar();
    }

    @Override
    public Car clone() {
        return new Car(year, color, getWheelDeepCopy(wheels), this.engine.clone());
    }

    private List<Wheel> getWheelDeepCopy(List<Wheel> wheels) {
        List<Wheel> wheelsDeepCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsDeepCopy.add(wheel.clone());
        }
        return wheelsDeepCopy;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

        public Car buildCar() {
            return new Car(this);
        }
    }
}

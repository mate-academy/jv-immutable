package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    private Car(CarBuilder carBuilder) {
        year = carBuilder.year;
        color = carBuilder.color;
        wheels = cloneDeepCopyOfList(carBuilder.wheels);
        engine = (carBuilder.engine == null) ? null : carBuilder.engine.clone();
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color='"
                + color + '\'' + ", wheels=" + wheels
                + ", engine=" + engine + '}';
    }

    @Override
    public Car clone() {
        return new CarBuilder().setYear(year)
                .setColor(color)
                .setEngine(engine.clone())
                .setWheels(cloneDeepCopyOfList(wheels))
                .createCar();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneDeepCopyOfList(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public static class CarBuilder {
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

        public Car createCar() {
            return new Car(this);
        }
    }

    public Car changeEngine(Engine engine) {
        return new CarBuilder()
                .setYear(year)
                .setColor(color)
                .setEngine(engine.clone())
                .setWheels(cloneDeepCopyOfList(wheels))
                .createCar();
    }

    public Car changeColor(String newColor) {
        return new CarBuilder()
                .setYear(year)
                .setColor(newColor)
                .setEngine(engine.clone())
                .setWheels(cloneDeepCopyOfList(wheels))
                .createCar();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = cloneDeepCopyOfList(wheels);
        list.add(newWheel);
        return new CarBuilder()
                .setYear(year)
                .setColor(color)
                .setEngine(engine.clone())
                .setWheels(list)
                .createCar();
    }

    private List<Wheel> cloneDeepCopyOfList(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }
}

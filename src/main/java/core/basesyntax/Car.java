package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> clonedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedWheels.add(new Wheel(wheel.getRadius()));
        }
        this.wheels = clonedWheels; // в видео пример поверхностного копирование!
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    private Car(Builder builder) {
        this.year = builder.year;
        this.color = builder.color;
        this.wheels = new ArrayList<>(builder.wheels);
        this.engine = builder.engine.clone();
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
        return engine != null ? engine.clone() : null;
    }

    public Car addWheel(Wheel newWheel) {
        Car carClone = this.clone();
        List<Wheel> wheelsActual = carClone.getWheels();
        wheelsActual.add(newWheel);
        return new Builder().setYear(carClone.year)
                            .setColor(carClone.color)
                            .setWheels(wheelsActual)
                            .setEngine(carClone.engine)
                            .build();
    }

    public Car changeColor(String newColor) {
        Car carClone = this.clone();
        return new Builder().setYear(carClone.year)
                            .setColor(newColor)
                            .setWheels(carClone.wheels)
                            .setEngine(carClone.engine)
                            .build();
    }

    public Car changeEngine(Engine engine) {
        Car carClone = this.clone();
        return new Builder().setYear(carClone.year)
                            .setColor(carClone.color)
                            .setWheels(carClone.wheels)
                            .setEngine(engine)
                            .build();
    }

    @Override
    public Car clone() {
        try {
            Car clonedCar = (Car) super.clone();
            Engine engine = this.getEngine();
            List<Wheel> wheels = clonedCar.getWheels();
            return new Builder().setYear(clonedCar.year)
                                .setColor(clonedCar.color)
                                .setWheels(wheels)
                                .setEngine(engine)
                                .build();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone for Car object", e);
        }
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
}

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

    public Car(int year, String color,List<Wheel> wheels,Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car(CarBuilder carBuilder) {
        this.year = carBuilder.year;
        this.color = carBuilder.color;
        this.wheels = new ArrayList<>(carBuilder.wheels);
        this.engine = carBuilder.engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color == null ? null : color;
    }

    public List<Wheel> getWheels() {
        return cloneList(this.wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year,newColor,wheels,engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = new Car(year,color,wheels,engine);
        newCar.wheels.add(newWheel.clone());
        return newCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car objCar = (Car) obj;
        return year == objCar.year
                && Objects.equals(color,objCar.color)
                && Objects.equals(wheels,objCar.wheels)
                && Objects.equals(engine,objCar.engine);
    }

    public List<Wheel> cloneList(List<Wheel> wheels) {
        List<Wheel> clonedList = new ArrayList<>();
        for (Wheel each:wheels) {
            clonedList.add(each.clone());
        }
        return clonedList;
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
}

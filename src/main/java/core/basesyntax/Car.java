package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels);
        this.engine = engine.clone();
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(Wheel wheel) {
        this.wheels.add(wheel);
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

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(new Engine(engine.getHorsePower(), engine.getManufacturer()));
    }

    public Car changeColor(String newColor) {
        return new Car(newColor);
    }

    public Car addWheel(Wheel newWheel) {
        return new Car(new Wheel(newWheel.getRadius()));
    }
}

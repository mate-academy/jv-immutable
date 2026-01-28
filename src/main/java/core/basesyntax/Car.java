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
        this.engine = (engine == null) ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheels.add(new Wheel(wheel.getRadius()));
        }
        this.wheels = copyWheels;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheels.add(new Wheel(wheel.getRadius()));
        }
        return copyWheels;
    }

    public Engine getEngine() {
        return (engine == null) ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.getWheels(), this.getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.getWheels(), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = this.getWheels();
        newWheels.add(new Wheel(wheel.getRadius()));
        return new Car(this.year, this.color, newWheels, this.getEngine());
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

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color='" + color + '\''
                + ", wheels=" + wheels + ", engine=" + engine + '}';
    }
}

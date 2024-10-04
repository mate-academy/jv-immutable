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
        this.wheels = wheels;
        this.engine = engine;
    }

    public Car(int year, String color, Engine engine, List<Wheel> wheels) {
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.wheels = new ArrayList<>(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, engine, this.wheels);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.engine, this.wheels);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, this.engine, this.wheels);
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
        return Objects.equals(color, car.color)
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
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
}

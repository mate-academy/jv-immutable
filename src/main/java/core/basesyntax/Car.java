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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.wheels = cloneAllWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Car changeColor(String color) {
        return new Car(year, color, cloneAllWheels(wheels), engine.clone());
    }

    public List<Wheel> getWheels() {
        return cloneAllWheels(wheels);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = cloneAllWheels(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine.clone());
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, cloneAllWheels(wheels), newEngine);
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

    private List<Wheel> cloneAllWheels(List<Wheel> wheels) {
        List<Wheel> result = new ArrayList<>();
        for (Wheel wheel : wheels) {
            result.add(wheel.clone());
        }
        return result;
    }
}

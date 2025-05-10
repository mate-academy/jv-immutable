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
        this.wheels = copyWheel(wheels);
        this.engine = engine == null ? null : engine.clone();

    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return copyWheel(wheels);
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = copyWheel(wheels);
        copyWheels.add(newWheel);
        return new Car(year, color, copyWheels, engine);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> copyWheel(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }
}

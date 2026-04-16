package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList());
        this.engine = engine == null ? null : engine.clone();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine == null ? null : engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine == null ? null : engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList());
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
}

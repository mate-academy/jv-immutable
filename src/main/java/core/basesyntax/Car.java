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
        this.wheels = getWheelsCopy(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        if (wheel == null) {
            return new Car(year, color, wheels, engine);
        }
        List<Wheel> copywheels = getWheelsCopy(wheels);
        copywheels.add(wheel);
        return new Car(year, color, copywheels, engine);

    }

    public int getYear() {
        return year;

    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    private List<Wheel> getWheelsCopy(List<Wheel> wheel) {
        List<Wheel> copyWheels = new ArrayList<>(wheel.size());
        for (Wheel wheels : wheel) {
            copyWheels.add(wheels != null ? wheels.clone() : null);
        }

        return copyWheels;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (Exception e) {
            throw new RuntimeException("Error while clonning car", e);
        }
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

        return Objects.equals(year, car.year)
                && Objects.equals(color, car.color)
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

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

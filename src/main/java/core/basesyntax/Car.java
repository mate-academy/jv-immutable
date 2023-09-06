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
        this.wheels = getCopyWheel(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    List<Wheel> getWheels() {
        return getCopyWheel(wheels);
    }

    Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getCopyWheel(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
    }

    @Override
    protected Car clone() {
        try {
            Car clone = (Car) super.clone();
            return clone;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create new Car");
        }
    }

    private static List<Wheel> getCopyWheel(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
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

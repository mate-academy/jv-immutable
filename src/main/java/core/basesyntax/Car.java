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
        this.wheels = getCopyWheels(wheels);
        this.engine = getCopyEngine(engine);
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public Engine getEngine() {
        return getCopyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getWheels(), newEngine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = new ArrayList<>(getWheels());
        newWheel.add(wheel);
        return new Car(year, color, newWheel, getEngine());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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

    private List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    private Engine getCopyEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

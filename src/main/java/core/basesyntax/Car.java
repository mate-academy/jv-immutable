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
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = this.getWheels();
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        if (engine != null) {
            return new Car(year, color, wheels, engine.clone());
        }
        return null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private List<Wheel> deepCopyWheels(List<Wheel> originalWheels) {
        List<Wheel> newWheels = new ArrayList<>(originalWheels.size());
        for (Wheel wheel : originalWheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car current = (Car) obj;
        return Objects.equals(color, current.color)
                && Objects.equals(wheels, current.wheels)
                && Objects.equals(engine, current.engine);
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

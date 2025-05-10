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
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        this.year = year;
        this.color = color;
        this.wheels = clonedWheels;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            clonedWheels.add(wheel.clone());
        }
        return new Car(this.year, this.color, clonedWheels, engine);
    }

    public Car changeColor(String newColor) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            clonedWheels.add(wheel.clone());
        }
        return new Car(this.year, newColor, clonedWheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            clonedWheels.add(wheel.clone());
        }
        clonedWheels.add(newWheel);
        return new Car(this.year, this.color, clonedWheels, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
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
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (engine == null) {
            this.engine = engine;
        } else {
            this.engine = engine.clone();
        }
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        this.wheels = copy;
        this.year = year;
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (wheels.isEmpty()) {
            return null;
        }
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null || getClass() != car.getClass()) {
            return false;
        }
        Car current = (Car) car;
        return year == current.year
                && Objects.equals(color, current.color)
                && Objects.equals(wheels, current.wheels)
                && Objects.equals(engine, current.engine);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : Objects.hashCode(this.color));
        result = 31 * result + (wheels == null ? 0 : Objects.hashCode(this.wheels));
        result = 31 * result + (engine == null ? 0 : Objects.hashCode(this.engine));
        return result;
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
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant create Car clone");
        }
    }
}

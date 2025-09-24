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
        this.year = year;
        this.color = color;
        this.engine = (engine == null) ? null : engine.clone();
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (wheels != null) {
            List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                wheelsCopy.add(wheel.clone());
            }
            return wheelsCopy;
        } else {
            return new ArrayList<>();
        }
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>(wheels);
        list.add(newWheel);
        return new Car(year, color, list, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Car.class)) {
            Car current = (Car) o;
            return year == current.year
                    && Objects.equals(color, current.color)
                    && Objects.equals(wheels, current.wheels)
                    && Objects.equals(engine, current.engine);
        }

        return false;
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

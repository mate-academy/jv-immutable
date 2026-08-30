package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneCollection(wheels);
        this.engine = checkEngineForNull(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneCollection(wheels);
    }

    public Engine getEngine() {
        return checkEngineForNull(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine);
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

    private List<Wheel> cloneCollection(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    private Engine checkEngineForNull(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public int hashCode() {
        int result = 17;
        result = result * 31 + year;
        result = result * 31 + (color == null ? 0 : color.hashCode());
        result = result * 31 + (wheels == null ? 0 : wheels.hashCode());
        result = result * 31 + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year && this.color.equals(current.color)
                    && this.wheels.equals(current.wheels)
                    && this.engine.equals(current.engine);
        }
        return false;
    }

}

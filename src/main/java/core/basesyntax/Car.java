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
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        Car cloneCar = new Car(year, color, getWheels(), engine.clone());
        cloneCar.wheels.add(newWheel);
        return cloneCar;
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
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

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> cloneWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

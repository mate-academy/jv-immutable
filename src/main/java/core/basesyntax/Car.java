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
        this.wheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels);
        wheelsCopy.add(wheel);
        return new Car(year, color, wheelsCopy, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
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
        return year == car.year && Objects.equals(color, car.color)
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
}

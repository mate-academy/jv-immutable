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
        this.wheels = getCloneWheels(wheels);
        this.engine = getCloneEngine(engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelClone = getCloneWheels(wheels);
        newWheelClone.add(wheels.size(), newWheel);
        return new Car(year, color, newWheelClone, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCloneWheels(wheels);
    }

    public Engine getEngine() {
        return getCloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private Engine getCloneEngine(Engine engine) {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    private List<Wheel> getCloneWheels(List<Wheel> wheels) {
        List<Wheel> cloneWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }
}

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
        this.wheels = getClonedWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getClonedWheels(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        Car newCar = new Car(year, newColor, wheels, engine.clone());
        return newCar;
    }

    public Car changeEngine(Engine engine) {
        Car newCar = new Car(year, color, wheels, engine);
        return newCar;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getClonedWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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

    private List<Wheel> getClonedWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }
}

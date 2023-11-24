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
        if (wheels == null) {
            throw new NullPointerException("Objects wheels are null");
        }
        List<Wheel> copy = new ArrayList<>();
        int count = 0;
        for (Wheel wheel : wheels) {
            copy.add(count, wheel.clone());
            count++;
        }
        this.year = year;
        this.color = color;
        this.wheels = copy;
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

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    @Override
    protected Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheel = new ArrayList<>(wheels.size() + 1);
        int count = 0;
        for (Wheel wheel : wheels) {
            copyWheel.add(wheel.clone());
            count++;
        }
        copyWheel.add(count, newWheel);
        return new Car(year, color, copyWheel, engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine.clone());
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

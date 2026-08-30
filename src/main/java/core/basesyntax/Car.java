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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = (engine == null) ? null : engine.clone();

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> cloneWheels = new ArrayList<>((wheels.size() + 1));
        for (Wheel wheel : wheels) {
            cloneWheels.add(wheel.clone());
        }
        cloneWheels.add(newWheel);
        return new Car(year, color, cloneWheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloneWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            cloneWheels.add(wheel.clone());
        }
        return cloneWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return engine;
        }
        return engine.clone();
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
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
        return Objects.equals(this.color, car.color)
                && Objects.equals(this.engine, car.engine)
                && Objects.equals(this.wheels, car.wheels)
                && year == car.year;
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

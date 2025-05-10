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
        List<Wheel> copyList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());
        }
        this.year = year;
        this.color = color;
        this.wheels = copyList;
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
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
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public List<Wheel> getWheels() {
        if (wheels == null) {
            return null;
        }
        List<Wheel> copyList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());
        }
        return copyList;
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine);
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

    public Car addWheel(Wheel wheel) {
        Car car = this.clone();
        car.wheels.add(wheel);
        return car;
    }

    public Car changeEngine(Engine expected) {
        return new Car(this.year, this.color, this.wheels, expected);
    }

    public Car changeColor(String blue) {
        return new Car(this.year, blue, this.wheels, this.engine);
    }
}

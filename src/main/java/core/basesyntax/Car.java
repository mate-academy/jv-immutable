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
        this.wheels = cloneListWheel(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneListWheel(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> wheels = cloneListWheel(this.wheels);
        return new Car(this.year, this.color, wheels, engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, cloneListWheel(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        return new Car(this.year, this.color, addNewWheel(newWheel), engine.clone());
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year && Objects.equals(this.color, current.color)
                    && this.wheels.equals(current.wheels) && this.engine.equals(current.engine);
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
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

    private List<Wheel> cloneListWheel(List<Wheel> current) {
        List<Wheel> copy = new ArrayList<>(current.size());
        for (Wheel wheel : current) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    private List<Wheel> addNewWheel(Wheel newWheel) {
        List<Wheel> result = cloneListWheel(wheels);
        result.add(newWheel.clone());
        return result;
    }
}

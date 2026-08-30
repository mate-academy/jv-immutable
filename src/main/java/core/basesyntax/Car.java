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
        this.wheels = copyWheels(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return (engine == null ? null : engine.clone());
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return year == other.year
                && color.equals(other.color)
                && engine.equals(other.engine)
                && wheels.equals(other.wheels);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(year);
        result = 31 * result + color.hashCode();
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        return result;
    }
}

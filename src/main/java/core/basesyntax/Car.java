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
        this.engine = engine == null ? null : engine.clone();
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels = cloneWheels(this.wheels);
        wheels.add(wheel);

        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }

        return copyWheels;
    }

    @Override
    public int hashCode() {
        int result = 79;
        result *= 31 * year;
        result *= 31 * color.hashCode();
        result *= 31 * wheels.hashCode();
        return result * 31 * engine.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() == Car.class) {
            Car current = (Car) obj;
            return year == current.year
                    && Objects.equals(current.color, color)
                    && Objects.equals(current.engine, engine)
                    && Objects.equals(current.wheels, wheels);
        }
        return false;
    }
}

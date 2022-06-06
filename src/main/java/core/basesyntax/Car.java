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
        this.wheels = getCopyOfWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getCopyOfWheels(wheels), newEngine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copy = getCopyOfWheels(wheels);
        copy.add(newWheel);
        return new Car(year, color, getCopyOfWheels(copy), engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    private static List<Wheel> getCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

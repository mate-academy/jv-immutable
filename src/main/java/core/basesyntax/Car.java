package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getCopyWheels(wheels), newEngine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copy = getCopyWheels(wheels);
        copy.add(newWheel);
        return new Car(year, color, getCopyWheels(copy), engine);
    }

    private static List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> carsCoppy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            carsCoppy.add(wheel.clone());
        }
        return carsCoppy;
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
        return year == car.year
                && Objects.equals(color, car.color)
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

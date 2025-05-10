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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.year = year;
        this.color = color;
        this.wheels = getWheelsClone(wheels);
        this.engine = getEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(wheels);
    }

    public Engine getEngine() {
        return getEngineClone(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsClone = getWheelsClone(wheels);
        wheelsClone.add(newWheel);
        return new Car(year, color, wheelsClone, engine);
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
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        return result;
    }

    private List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> wheelsClone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsClone.add(wheel.clone());
        }
        return wheelsClone;
    }

    private Engine getEngineClone(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }
}

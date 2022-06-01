package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheels(wheels);
        this.engine = engineInit(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        wheelsCopy.addAll(wheels);
        wheelsCopy.add(newWheel);
        return new Car(year, color, wheelsCopy, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(this.wheels.size());
        for (Wheel wheel : this.wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public List<Wheel> getWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return engineInit(engine);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + year;
        hash = hash * 31 + (color == null ? 0 : color.hashCode());
        hash = hash * 31 + (wheels == null ? 0 : wheels.hashCode());
        hash = hash * 31 + (engine == null ? 0 : engine.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car car = (Car) obj;
            return (year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine));
        }
        return false;
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
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone object", e);
        }
    }

    private static Engine engineInit(Engine en) {
        return en == null ? null : en.clone();
    }
}

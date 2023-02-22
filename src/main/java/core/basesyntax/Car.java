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
        this.wheels = getCopy(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return engine;
        }
        return engine.clone();
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
            Car newCar = (Car) car;
            return year == newCar.year && Objects.equals(color, newCar.color)
                    && Objects.equals(wheels, newCar.wheels)
                    && Objects.equals(engine, newCar.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color='" + color + '\''
                + ", wheels=" + wheels + ", engine=" + engine + '}';
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getCopy(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

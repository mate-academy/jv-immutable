package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return wheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);

    }

    public Car addWheel(Wheel newWheel) {
        Car carForCopy = new Car(year, color, wheels, engine);
        carForCopy.wheels.add(newWheel.clone());
        return carForCopy;
    }

    private List<Wheel> wheelsCopy(List<Wheel> wheels) {
        List<Wheel> wheelCopy = new ArrayList<>();
        for (Wheel copy : wheels) {
            wheelCopy.add(copy.clone());
        }
        return wheelCopy;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + year;
        result = result * 31 + (color == null ? 0 : color.hashCode());
        result = result * 31 + (wheels == null ? 0 : wheels.hashCode());
        result = result * 31 + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null || getClass() != car.getClass()) {
            return false;
        }
        Car newCar = (Car) car;
        return year == newCar.year && Objects.equals(color, newCar.color)
                && Objects.equals(wheels, newCar.wheels) && Objects.equals(engine, newCar.engine);
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Car object", e);
        }
    }
}

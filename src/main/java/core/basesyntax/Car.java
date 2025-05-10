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
        this.wheels = getWheelsCopy(wheels);
        this.engine = getEngineCopy(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, getEngineCopy(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheelsCopy(wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return getEngineCopy(engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return getYear() == car.getYear()
                && getColor().equals(car.getColor())
                && getWheels().equals(car.getWheels())
                && getEngine().equals(car.getEngine());
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

    private static List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> wheelCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }

    private static Engine getEngineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

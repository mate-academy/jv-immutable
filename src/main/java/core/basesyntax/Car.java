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

    public Car(int year, String color, List<Wheel> testWheels, Engine engine) {
        if (testWheels == null) {
            throw new NullPointerException();
        } else {
            wheels = new ArrayList<>(testWheels.size());
            for (Wheel wheel : testWheels) {
                wheels.add(wheel.clone());
            }
            this.year = year;
            this.color = color;
            this.engine = (engine == null) ? null : engine.clone();

        }
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car changeEngine(Engine engine) {
        Car changedCar = new Car(this.year, this.color, this.wheels, engine);
        return changedCar;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size() + 1);
        wheelsCopy.addAll(wheels);
        wheelsCopy.add(newWheel);
        Car changedCar = new Car(this.year, this.color, wheelsCopy, this.engine);
        return changedCar;
    }

    public Car changeColor(String newColor) {
        Car newCar = new Car(this.year, newColor, this.wheels, this.engine);
        return newCar;
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
            throw new RuntimeException("Unable to clone Car object ", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Car current = (Car) o;
        return (this.year == current.year && Objects.equals(this.color, current.color)
                && Objects.equals(this.engine, current.engine)
                && Objects.equals(this.wheels, current.wheels));
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, engine, wheels);
    }
}

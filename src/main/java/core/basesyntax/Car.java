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
        this.wheels = copyOfWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    private List<Wheel> copyOfWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.getWheels(), this.getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            updatedWheels.add(wheel.clone());
        }
        updatedWheels.add(newWheel.clone());
        return new Car(this.year, this.color, updatedWheels, this.getEngine());
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
        Car car = (Car) obj;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }
}

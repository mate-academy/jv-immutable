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
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        this.wheels = newWheels;
        this.engine = engine != null ? engine.clone() : null;
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
        return engine != null ? engine.clone() : null;
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    @Override
    public Car clone() {
        try {
            Car car = (Car) super.clone();
            return car;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Wheel", e);
        }
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
        return this.year == car.year
                && this.color.equals(car.color)
                && this.wheels.equals(car.wheels)
                && this.engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, getCopy(this.wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, getCopy(this.wheels),
                this.engine != null ? this.engine.clone() : null);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copiedWheels = getCopy(this.wheels);
        copiedWheels.add(newWheel.clone());
        return new Car(this.year, this.color, copiedWheels,
                this.engine != null ? this.engine.clone() : null);
    }
}

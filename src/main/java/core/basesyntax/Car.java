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
        this.wheels = getWheelCopy(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return this.engine.clone();
    }

    private List<Wheel> getWheelCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car addWheel(Wheel wheel) {
        Objects.requireNonNull(wheel, "Wheel must be not null");
        List<Wheel> wheelCopy = getWheelCopy(wheels);
        wheelCopy.add(wheel.clone());
        return new Car(this.year, this.color, wheelCopy, this.engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        Objects.requireNonNull(newEngine, "Engine must to be not null");
        return new Car(this.year, this.color, this.wheels, newEngine.clone());
    }

    public Car changeColor(String newColor) {
        Objects.requireNonNull(newColor, "Color must to be not null");
        return new Car(this.year, newColor, this.wheels, this.engine.clone());
    }

    @Override
    public boolean equals(Object o) {
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

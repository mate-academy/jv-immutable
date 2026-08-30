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
        this.engine = (engine == null) ? null : engine.clone();
        this.wheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
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
        return (engine != null) ? engine.clone() : null;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyWheels(wheels), (engine != null)
                ? engine.clone() : null);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getCopyWheels(wheels), (newEngine != null)
                ? newEngine.clone() : null);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = getCopyWheels(wheels);
        wheelsCopy.add(newWheel.clone());
        return new Car(year, color, wheelsCopy, (engine != null) ? engine.clone() : null);
    }

    private List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
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
                && color.equals(car.color)
                && wheels.equals(car.wheels)
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

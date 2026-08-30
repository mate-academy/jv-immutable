package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private static final int MAGIC_HASH_MULTIPLICATOR = 31;
    private static final int MAGIC_HASH_CONSTANT = 17;

    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyWheelList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    private List<Wheel> copyWheelList(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel == null ? null : wheel.clone());
        }
        return wheelsCopy;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheelList(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return MAGIC_HASH_MULTIPLICATOR * MAGIC_HASH_CONSTANT + year
                * MAGIC_HASH_MULTIPLICATOR + (color == null ? 0 : color.hashCode())
                * MAGIC_HASH_MULTIPLICATOR + (wheels == null ? 0 : wheels.hashCode())
                * MAGIC_HASH_MULTIPLICATOR + (engine == null ? 0 : engine.hashCode());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }
}

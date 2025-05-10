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
        this.wheels = getCopyWheels(wheels);
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Car car = (Car) object;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
            && Objects.equals(getWheels(), car.getWheels()) && Objects.equals(
            getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + Objects.hashCode(getColor());
        result = 31 * result + Objects.hashCode(getWheels());
        result = 31 * result + Objects.hashCode(getEngine());
        return result;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getCopyWheels(wheels), new Engine(engine.getHorsePower(),
            engine.getManufacturer()));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopyWheels(wheels), new Engine(engine.getHorsePower(),
            engine.getManufacturer()));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = getCopyWheels(wheels);
        copyWheels.add(newWheel);
        return new Car(year, color, copyWheels, new Engine(engine.getHorsePower(),
            engine.getManufacturer()));
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
        if (engine != null) {
            return new Engine(engine.getHorsePower(), engine.getManufacturer());
        } else {
            return null;
        }
    }

    private List<Wheel> getCopyWheels(List<Wheel> originalWheel) {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : originalWheel) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }
}

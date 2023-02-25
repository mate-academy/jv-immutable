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
        this.wheels = getClonedWheels(wheels);
        this.engine = getClonedEngine(engine);
        this.year = year;
        this.color = color;

    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());

        }
        return copyList;
    }

    public Engine getEngine() {
        return getClonedEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, getClonedEngine(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> oldWheels = getClonedWheels(wheels);
        oldWheels.add(newWheel);
        return new Car(year, color, oldWheels, engine);
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine);
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> getClonedWheels(List<Wheel> original) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel originalWheel : original) {
            if (originalWheel == null) {
                clonedWheels.add(null);
            } else {
                clonedWheels.add(originalWheel.clone());
            }
        }
        return clonedWheels;
    }

    private Engine getClonedEngine(Engine originalEngine) {
        return originalEngine == null ? null : originalEngine.clone();

    }
}

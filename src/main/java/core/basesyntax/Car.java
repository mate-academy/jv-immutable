package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, wheels, engine);
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel thisWheel : wheels) {
            clonedWheels.add(thisWheel.clone());
        }
        return clonedWheels;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newListOfWheels = new ArrayList<>();
        newListOfWheels.add(newWheel);
        return new Car(getYear(), getColor(), newListOfWheels,engine);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(getYear(), getColor(), wheels, newEngine);
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
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), wheels, engine);
    }
}

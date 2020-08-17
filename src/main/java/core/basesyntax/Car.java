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
        this.wheels = getWheelsCopy(wheels);
        this.year = year;
        this.color = color;
        this.engine = getEngineCopy(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !o.getClass().equals(Car.class)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear()
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    private Engine getEngineCopy(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> newWheelsArray = new ArrayList<>();
        for (Wheel w : wheels) {
            newWheelsArray.add(w.clone());
        }
        return newWheelsArray;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color,
                wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor,
                wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsArray = getWheelsCopy(this.wheels);
        newWheelsArray.add(newWheel);
        return new Car(year, color, newWheelsArray, engine);
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
}

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
        this.wheels = wheelsCopy(wheels);
        this.engine = cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel);
        return car;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return wheelsCopy(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    private Engine cloneEngine(Engine engine) {
        return (engine == null) ? null : engine.clone();
    }

    private List<Wheel> wheelsCopy(List<Wheel> wheels) {
        List<Wheel> newWheelsList = new ArrayList<>();
        for (Wheel wheel: wheels) {
            if (wheel != null) {
                newWheelsList.add(wheel.clone());
            } else {
                newWheelsList.add(null);
            }
        }
        return newWheelsList;
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

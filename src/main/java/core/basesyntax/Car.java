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
        this.wheels = wheelsClone(wheels);
        this.engine = engineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsClone(wheels);
    }

    public Engine getEngine() {
        return engineClone(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), getEngine());

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsList = getWheels();
        wheelsList.add(newWheel);
        return new Car(year, color, wheelsList, getEngine());

    }

    private Engine engineClone(Engine item) {
        return (item != null) ? item.clone() : null;
    }

    private List<Wheel> wheelsClone(List<Wheel> wheels) {
        List<Wheel> output = new ArrayList<>();
        for (Wheel item : wheels) {
            output.add(item.clone());
        }
        return output;
    }

    @Override
    public boolean equals(Object anotherCar) {
        if (this == anotherCar) {
            return true;
        }
        if (anotherCar == null || this.getClass() != anotherCar.getClass()) {
            return false;
        }
        Car car = (Car) anotherCar;
        return year == car.year
                && color.equals(car.color)
                && wheels.equals(car.wheels)
                && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

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
        this.wheels = deepWheelCopy(wheels);
        this.engine = engineClone(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(wheel);
        return new Car(year,color, newWheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> deepWheelCopy(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<Wheel>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
    }

    private Engine engineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Engine getEngine() {
        return engineClone(engine);
    }

    public List<Wheel> getWheels() {
        return deepWheelCopy(wheels);
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
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
        return Objects.hash(year, color, wheels, engine);
    }
}

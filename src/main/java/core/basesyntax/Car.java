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
        this.wheels = wheelsListClone(wheels);
        this.engine = engineClone(engine);
    }

    private Engine engineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsListClone(wheels);
    }

    public Engine getEngine() {
        return engineClone(engine);
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

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsWithNewWheel = getWheels();
        wheelsWithNewWheel.add(newWheel.clone());
        return new Car(year, color, wheelsWithNewWheel, engine);
    }

    private List<Wheel> wheelsListClone(List<Wheel> wheels) {
        List<Wheel> wheelListClone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel == null) {
                wheelListClone.add(null);
            } else {
                wheelListClone.add(wheel.clone());
            }
        }
        return wheelListClone;
    }
}

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
        this.wheels = getWheelListClone(wheels);
        this.engine = getEngineClone(engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, wheels, engine, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelListClone(wheels);
    }

    public Engine getEngine() {
        return getEngineClone(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsNew = getWheelListClone(wheels);
        wheelsNew.add(newWheel);
        return new Car(year, color, wheelsNew, engine);
    }

    private List<Wheel> getWheelListClone(List<Wheel> wheelListOriginal) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel: wheelListOriginal) {
            if (wheel != null) {
                newList.add(wheel.clone());
            } else {
                newList.add(null);
            }
        }
        return newList;
    }

    private Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getClonedWheels(wheels);
        this.engine = engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getClonedWheels(wheels);
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        return new Car(year, color, wheels, engine.clone());
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

    private List<Wheel> getClonedWheels(List<Wheel> wheels) {
        List<Wheel> destanation = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            destanation.add(wheel.clone());
        }
        return destanation;
    }
}

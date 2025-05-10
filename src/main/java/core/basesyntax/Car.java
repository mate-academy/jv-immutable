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
        this.wheels = getCopyWheel(wheels);
        this.engine = getCopyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheel(wheels);
    }

    public Engine getEngine() {
        return getCopyEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelList = new ArrayList<>(wheels);
        wheelList.add(wheel);
        return new Car(year,color,wheelList,engine);
    }

    public Car changeColor(String color) {
        return new Car(year,color,wheels,engine);
    }
    //implement this class

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

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

    private static Engine getCopyEngine(Engine engine) {
        if (engine == null) {
            return null;
        }
        Engine engineCopy;
        engineCopy = engine.clone();
        return engineCopy;
    }

    private static List<Wheel> getCopyWheel(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            wheelsCopy.add((Wheel) wheel.clone());
        }
        return wheelsCopy;
    }
}

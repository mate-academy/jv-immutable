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
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        this.wheels = wheelList;
        this.engine = (engine == null) ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != Car.class) {
            return false;
        }
        Car carObj = (Car) obj;
        return year == carObj.year
                && color.equals(carObj.color)
                && wheels.equals(carObj.wheels)
                && engine.equals(carObj.engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = new ArrayList<>(getWheels());
        wheelList.add(newWheel);
        return new Car(getYear(), getColor(), wheelList, getEngine());
    }
}

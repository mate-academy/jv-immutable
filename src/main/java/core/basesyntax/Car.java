package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(deepCopy(wheels));
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, deepCopy(wheels), engine);
    }

    public Car changeColor(String newColor) {
        Engine engine1 = null;
        if (engine != null) {
            engine1 = engine.clone();
        }
        return new Car(year, newColor, deepCopy(wheels), engine1);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>(wheels.size() + 1);
        for (int i = 0; i < wheels.size(); i++) {
            list.add(wheels.get(i).clone());
        }
        list.add(newWheel);
        return new Car(year, color, list, engine.clone());
    }

    //implement this class

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        if (this == null) {
            return null;
        }
        return clone().wheels;
    }

    public Engine getEngine() {
        Engine engine1 = null;
        if (engine != null) {
            engine1 = engine.clone();
        }
        return engine1;
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

    public List<Wheel> deepCopy(List<Wheel> list) {
        List<Wheel> wheelList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            wheelList.add(list.get(i).clone());
        }
        return wheelList;
    }

    @Override
    protected Car clone() {
        Engine engine1 = null;
        if (engine != null) {
            engine1 = engine.clone();
        }
        return new Car(year, color, deepCopy(wheels), engine1);
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel item : wheels) {
            newWheels.add(new Wheel(item.getRadius()));
        }
        this.wheels = newWheels;
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> tempList = new ArrayList<>();
        for (Wheel element : wheels) {
            tempList.add(new Wheel(element.getRadius()));
        }
        return tempList;
    }

    public Engine getEngine() {
        return (engine == null) ? null : new Engine(engine.getHorsePower(),
                engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(), newColor, getWheels(), getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = this.getWheels();
        newList.add(new Wheel(newWheel.getRadius()));
        return new Car(this.getYear(), getColor(), newList, getEngine());
    }

    @Override
    public Car clone() {
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return new Car(getYear(), getColor(), list, engine.clone());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car o = (Car) obj;
        return year == o.year && ((color == null && o.color == null)
                                || (color != null && color.equals(o.color))
                             && ((engine == null && o.engine == null)
                                || engine != null && engine.equals(o.engine))
                             && wheels.equals(o.wheels));
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 7 * result + year;
        result = 7 * result + ((color == null) ? 0 : color.hashCode());
        result = 7 * result + engine.hashCode();
        result = 7 * result + wheels.hashCode();
        return result;
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
}

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
    private final Engine engine;

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(),getColor(),getWheels(),engine);
    }

    public Car changeColor(String color) {
        return new Car(getYear(),color,getWheels(),getEngine());
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return getWheelCopy(wheels);
    }

    public String getColor() {
        return color;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> cloneList = new ArrayList<>(wheels.size());

        for (Wheel wheelClone : wheels) {
            cloneList.add(wheelClone.clone());
        }
        cloneList.add(wheel);
        return new Car(getYear(),getColor(),cloneList,getEngine());
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + wheels.hashCode();
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            return current.year == year && current.color.equals(color)
                    && current.wheels.equals(wheels)
                    && current.engine.equals(engine);
        }
        return false;
    }

    private List<Wheel> getWheelCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
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

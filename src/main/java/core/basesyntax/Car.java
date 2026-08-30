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
        this.wheels = getClonedList(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getClonedList(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private List<Wheel> getClonedList(List<Wheel> origin) {
        List<Wheel> clonedList = new ArrayList<>(origin.size());
        for (Wheel wheelToClone : origin) {
            clonedList.add(wheelToClone.clone());
        }
        return clonedList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !getClass().equals(object.getClass())) {
            return false;
        }
        Car car = (Car) object;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + year;
        result = 37 * result + (color == null ? 0 : color.hashCode());
        result = 37 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 37 * result + (engine == null ? 0 : engine.hashCode());
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

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, new Engine(engine.getHorsePower(),
                 engine.getManufacturer()));
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels1 = new ArrayList<>(getClonedList(wheels));
        wheels1.add(wheel);
        return new Car(year, color, wheels1, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }
}

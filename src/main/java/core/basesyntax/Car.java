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
        this.wheels = getCloneWheels(wheels);
        this.engine = getCloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheels) {
        List<Wheel> list = getWheels();
        list.add(newWheels);
        return new Car(year, color, list, engine);
    }

    public List<Wheel> getWheels() {
        return getCloneWheels(wheels);
    }

    public Engine getEngine() {
        return getCloneEngine(engine);
    }

    @Override
    public Car clone() {
        try {
            return (Car)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t be cloned", e);
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
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
        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!Objects.equals(wheels, car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
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

    private List<Wheel> getCloneWheels(List<Wheel> wheels) {
        List<Wheel> listCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            listCopy.add(wheel.clone());
        }
        return listCopy;
    }

    private Engine getCloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

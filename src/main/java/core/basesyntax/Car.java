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
        this.wheels = newWheelsList(wheels);
        this.engine = engine == null ? null : new Engine(engine);
    }

    private List<Wheel> newWheelsList(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloneWheel = new ArrayList<>();
        for(Wheel wheel: wheels) {
            cloneWheel.add(wheel.clone());
        }
        return cloneWheel;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> cloneW = new ArrayList<>();
        for(Wheel wheel: wheels) {
            cloneW.add(wheel.clone());
        }
        cloneW.add(newWheel);
        return new Car(year, color, cloneW, engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, year, engine, wheels);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year &&
                Objects.equals(color, car.color)
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
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

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone for Car", e);
        }
    }
}

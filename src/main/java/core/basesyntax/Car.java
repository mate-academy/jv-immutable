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
    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> newWheesls = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheesls.add(wheel.clone());
        }
        this.wheels = newWheesls;
        this.engine = engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheesls = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheesls.add(wheel.clone());
        }
        return newWheesls;
    }

    public int getYear() {
        return year;
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
            return Objects.equals(this.color, current.color)
                    && Objects.equals(this.engine, current.engine)
                    && (this.year == current.year)
                    && Objects.equals(this.wheels, current.wheels);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + ((color == null) ? 0 : color.hashCode());
        result = 31 * result + ((wheels == null) ? 0 : wheels.hashCode());
        result = 31 * result + ((engine == null) ? 0 : engine.hashCode());
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

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>();
        newWheels.addAll(wheels);
        if (wheel == null) {
            throw new NullPointerException();
        } else {
            newWheels.add(wheel);
        }
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String blue) {
        return new Car(year, blue, wheels, engine);
    }

    public Car changeEngine(Engine otherMaker) {
        if (otherMaker == null) {
            throw new NullPointerException();
        }
        return new Car(year, color, wheels, otherMaker);
    }
}

package core.basesyntax;

import java.util.List;
import java

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
        this.wheels = getCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }


    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return ;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (RuntimeException e) {
            throw new RuntimeException("Object can't be cloned");
        }
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

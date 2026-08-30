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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels can not be null");
        }
        this.year = year;
        this.color = color == null ? null : color.toString();
        this.engine = engine == null ? null : engine.clone();
        this.wheels = wheels == null ? null : cloneWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color == null ? null : color.toString();
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return wheels == null ? null : cloneWheels(wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = cloneWheels(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
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
    public int hashCode() {
        int wheelHashCode = 0;
        for (Wheel wheel: wheels) {
            wheelHashCode += wheel.hashCode();
        }
        return this.year + this.color.hashCode() + this.engine.hashCode() + wheelHashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass().equals(Car.class)) {
            Car casted = (Car) obj;
            if (
                        casted.year == this.year
                        && (this.color == null && casted.color == null
                          || (this.color != null && this.color.equals(casted.color)))
                        && (this.engine == null && casted.engine == null
                          || (this.engine != null && this.engine.equals(casted.engine)))
                        && (this.wheels.equals(casted.wheels))
            ) {
                return true;
            }
        }

        return false;
    }
}

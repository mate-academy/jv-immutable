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
        try {
            cloneWheels(wheels);
        } catch (NullPointerException e) {
            throw new NullPointerException("Wheels can't be null" + e);
        } finally {
            this.wheels = cloneWheels(wheels);
        }
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return (wheels == null) ? null : cloneWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
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
    public int hashCode() {
        int wheelsHashCode = 0;
        for (Wheel wheel: wheels) {
            wheelsHashCode += wheel.hashCode();
        }
        return this.year + this.color.hashCode() + this.engine.hashCode() + wheelsHashCode;
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
        return car.year == this.year
                && (this.color == null && car.color == null
                || (this.color != null && this.color.equals(car.color)))
                && (this.engine == null && car.engine == null
                || (this.engine != null && this.engine.equals(car.engine)))
                && (this.wheels.equals(car.wheels));
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

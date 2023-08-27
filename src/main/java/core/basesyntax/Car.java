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
        this.wheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
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
        return getWheelsCloned();
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine + '}';
    }

    @Override
    protected Object clone() {
        List<Wheel> newWheels = getWheelsCloned();
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    public Car changeEngine(Engine newEngine) {
        List<Wheel> newWheels = getWheelsCloned();
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    public Car changeColor(String newColor) {
        List<Wheel> newWheels = getWheelsCloned();
        return new Car(this.year, newColor, newWheels, this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheelsCloned();
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

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
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    private List<Wheel> getWheelsCloned() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel oldWheel : wheels) {
            newWheels.add(oldWheel.clone());
        }
        return newWheels;
    }
}

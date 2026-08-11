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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.color = color;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        this.year = year;
        this.wheels = copyWheels(wheels);

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
        if (engine == null) {
            return new Car(this.year, this.color, wheels, null);
        } else {
            return new Car(this.year, this.color, wheels, engine.clone());
        }
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        ArrayList<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return this.year == other.year
                && this.engine.equals(other.engine)
                && this.wheels.equals(other.wheels)
                && this.color.equals(other.color);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(year) * 17
                + Objects.hashCode(engine) * 21
                + Objects.hashCode(color) * 17
                + Objects.hashCode(wheels) * 31;
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
    }
}

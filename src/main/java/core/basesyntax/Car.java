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
        this.wheels = new ArrayList<>();
        this.engine = (engine == null) ? null : engine.clone();
        for (Wheel wheel: wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            return null;
        } else {
            return new Car(this.year, this.color, this.wheels, engine).clone();
        }
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            return null;
        } else {
            return new Car(this.year, newColor, this.wheels, this.engine).clone();
        }
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return null;
        } else {
            List<Wheel> newWheels = new ArrayList<>(this.wheels);
            newWheels.add(newWheel.clone());
            return new Car(this.year, this.color, newWheels, this.engine).clone();
        }
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    protected Car clone() {
        Engine clonedEngine = engine == null ? null : engine.clone();
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return new Car(this.year, this.color, clonedWheels, clonedEngine);
    }
}

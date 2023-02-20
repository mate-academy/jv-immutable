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
        this.year = year;
        this.color = color;
        this.engine = getEngineClone(engine);
        this.wheels = copyWheels(wheels);
    }
    //implement this class

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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return new String(color);
    }

    public Engine getEngine() {
        return getEngineClone(engine);
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = copyWheels(this.wheels);
        newWheel.add(wheel);
        return new Car(this.year, this.color, newWheel, this.engine);
    }

    public Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            newWheels.add(wheels.get(i).clone());
        }
        return newWheels;
    }
}

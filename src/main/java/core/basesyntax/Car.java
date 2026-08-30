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
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        }

        this.year = year;
        this.color = color;
        this.wheels = getCloneWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
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
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels,
        car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year + ", color" + color + '\'' + ", wheels=" + ", "
                + "engine=" + engine + '}';
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCloneWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine expected) {
        return new Car(year, color, wheels, expected);
    }

    public Car changeColor(String colors) {
        return new Car(this.year, colors, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        if (wheel == null) {
            throw new IllegalArgumentException("Cannot add a null wheel to the car");
        }

        List<Wheel> newWheel = new ArrayList<>(this.wheels);
        newWheel.add(wheel);
        return new Car(this.year, this.color, newWheel, this.engine);
    }

    public Engine getEngine() {
        Car car = new Car(year, color, wheels, engine);
        if (car.engine != null) {
            Engine engine = car.engine;
            return engine.clone();
        }
        return null;
    }

    private List<Wheel> getCloneWheels(List<Wheel> wheels) {
        List<Wheel> copyOriginalWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel: wheels) {
            copyOriginalWheel.add(wheel.clone());
        }
        return copyOriginalWheel;
    }
}

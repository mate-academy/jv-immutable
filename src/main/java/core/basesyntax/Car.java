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

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = deepCopyList(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    private List<Wheel> deepCopyList(List<Wheel> wheels) {
        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null");
        } else {
            List<Wheel> newWheels = new ArrayList<>();
            for (Wheel wheel : wheels) {
                newWheels.add(wheel.clone());
            }
            return newWheels;
        }
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Car changeColor(String color) {
        return new Car(getYear(),color,getWheels(),getEngine());

    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> result = getWheels();
        result.add(newWheel);
        return new Car(year,color,result,engine);
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(getYear(), getColor(), getWheels(), otherMaker);
    }
}

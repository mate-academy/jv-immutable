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
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());

        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        this.wheels = wheelsCopy;

        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = engine;
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        if (this.engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }

    public Car changeColor(String newColor) {
        Car car = new Car(year,newColor,this.getWheels(),this.getEngine());
        return car;
    }

    public Car changeEngine(Engine engine) {
        Car car = new Car(year,color,this.getWheels(),engine.clone());
        return car;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());

        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        wheelsCopy.add(newWheel.clone());

        Car car = new Car(year,color,wheelsCopy,engine.clone());
        return car;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t create clone Car",e);
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

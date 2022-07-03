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
        this.wheels = new ArrayList<>(cloneAllWheel(wheels));
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> cloneAllWheel(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel newWheelsList: wheels) {
            newWheels.add(newWheelsList.clone());
        }
        return newWheels;
    }

    public List<Wheel> getWheels() {
        return cloneAllWheel(wheels);
    }

    public Engine cloneEngine(Engine engine) {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.clone().getHorsePower(),
                engine.clone().getManufacturer());
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, cloneEngine(engine));
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> addNewWheel = cloneAllWheel(wheels);
        addNewWheel.add(wheel);
        return new Car(year, color, addNewWheel, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
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
}

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

        this.engine = engine == null ? null : engine.clone();

        List<Wheel> newWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheel.add(new Wheel(wheel.getRadius()));
        }
        this.wheels = newWheel;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car setEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheel.add(new Wheel(wheel.getRadius()));
        }
        return newWheel;
    }

    public Car setWheels(List<Wheel> wheels) {
        return new Car(year, color, wheels, getEngine());
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheel = new ArrayList<>(this.wheels);
        newWheel.add(wheel);
        return new Car(year, color, newWheel, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), engine);
    }

    public int getYear() {
        return year;
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

    @Override
    public Car clone() {
        Car clonedCar;
        try {
            clonedCar = (Car) super.clone();
            clonedCar.setWheels(this.getWheels());
            clonedCar.setEngine(this.engine.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't to create clone of Car object", e);
        }
        return clonedCar;
    }
}

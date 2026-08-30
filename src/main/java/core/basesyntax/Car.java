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
        if (wheels == null) {
            throw new NullPointerException();
        } else {
            this.wheels = deepCopy(wheels);
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyOfWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyOfWheels.add(wheel.clone());
        }
        return copyOfWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheelLoc : wheels) {
            newWheels.add(new Wheel(wheelLoc.getRadius()));
        }
        newWheels.add(new Wheel(wheel.getRadius()));
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> deepCopy(List<Wheel> wheelList) {
        List<Wheel> wheels1 = new ArrayList<>(wheelList.size());
        for (Wheel wheel : wheelList) {
            wheels1.add(wheel.clone());
        }
        return wheels1;
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), engine);
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

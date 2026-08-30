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
        this.wheels = getWheelsCopy(wheels);
        this.engine = getEngineCopy(engine);
    }

    //implement this class
    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }

        return copyWheels;
    }

    private Engine getEngineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        System.out.println("Origin car: " + this);
        Car cloneCar = this.clone();
        cloneCar.wheels.add(wheel);
        System.out.println("Origin car: " + this);
        System.out.println("Clone car: " + cloneCar);

        return cloneCar;
    }

    public Car changeEngine(Engine engine) {
        Car cloneCar = new Car(year, color, wheels, engine);
        return cloneCar;
    }

    public Car changeColor(String color) {
        Car cloneCar = new Car(year, color, wheels, engine);
        return cloneCar;
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
    public Car clone() {
        return new Car(year, color, wheels, engine);
    }
}

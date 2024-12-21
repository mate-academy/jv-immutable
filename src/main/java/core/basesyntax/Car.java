package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    //implement this class




    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(getWheels());
        this.engine = engine.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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
        return engine.clone();
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }


    public Car changeColor(String blue) {
        try {
            Car updatedCar = (Car) super.clone();
            updatedCar.color = blue;
            return updatedCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Car addWheel(Wheel wheel) {
        try {
            Car updatedCar = (Car) super.clone();
            updatedCar.wheels.add(wheel);
            return updatedCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    public Car changeEngine(Engine otherMaker) {
        try {
            Car updatedCar = (Car) super.clone();
            updatedCar.engine = otherMaker;
            return updatedCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

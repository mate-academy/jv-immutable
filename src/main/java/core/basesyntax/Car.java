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
        this.wheels = wheels;
        this.engine = engine;
        /*if (wheels == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }*/
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
        List<Wheel> newWheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                newWheelList.add(wheel.clone());
            }
        }
        return newWheelList;
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newListOfWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                newListOfWheels.add(wheel.clone());
            }
        }
        newListOfWheels.add(newWheel);
        return new Car(year, color, newListOfWheels, engine);
    }

    /*@Override
    protected Object clone() {
        Car car;
        List<Wheel> newWheelList = wheels;
        try {
            car = new Car(this.getYear(), this.getColor(), this.getWheels(), this.engine.clone());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return car;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (!Objects.equals(color, car.color)) return false;
        if (!Objects.equals(wheels, car.wheels)) return false;
        return Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}

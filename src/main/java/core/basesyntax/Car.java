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
    private Engine engine;
    private List<Wheel> wheels;


    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsDeepClone(wheelsDeepClone(wheels));///
    }

    public Engine getEngine() {
        return engine;
    }

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.engine = engine.clone();
    }
//implement this class
    public Car changeColor(String newColor) {
       return new Car(year, newColor, wheelsDeepClone(wheels), engine.clone()); ///
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel != null) {
            wheels.add(newWheel);
        }
        return new Car(year, color, wheelsDeepClone(wheels), engine.clone()); ///
    }

    public Car changeEngine(Engine engine){
        if (engine == null) {
            engine = this.engine;
        }
        return new Car(year, color, wheelsDeepClone(wheels), engine);///
    }

    public  List<Wheel> wheelsDeepClone(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

//qwrijrfvdjlds;s'djjj
//kxkxcjvhxxlx;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor()) && Objects.equals(getWheels(), car.getWheels()) && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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

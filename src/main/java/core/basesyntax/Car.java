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
    public Car (int year,  String color) {
        this.year = year;
        this.color = color;
    }

    public Car (int year,  String color, Engine engine,  List<Wheel> wheels) {
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
    }

    public void addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel.clone());
        this.wheels.clear();
        this.wheels.addAll(newWheels);
    }

    public changeColor(String newColor) {
    }

    public changeEngine(Engine engine) {

    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels);
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
      return  engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
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
    public int hashCode() {
        return Objects.hash(color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car otherCar = (Car) obj;
        return Objects.equals(color, otherCar.color) &&
                Objects.equals(wheels, otherCar.wheels) &&
                Objects.equals(engine, otherCar.engine);
    }

}

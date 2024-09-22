package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private  List<Wheel> wheels;
    private  Engine engine;

    public Car(int year, String color) {
        this.year = year;
        this.color = color;
    }

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.engine = engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor (String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }
    public Car addWheel (Wheel WHEEL1) {
    List<Wheel> WHEEL2 = new ArrayList<>(this.wheels);
    WHEEL2.add(WHEEL1);
    return new Car(this.year,this.color, WHEEL2, this.engine);
}
//implement this class

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

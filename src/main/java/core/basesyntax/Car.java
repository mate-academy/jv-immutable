package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;

    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<Wheel>();
        for (Wheel wheel : wheels
        ) {
            this.wheels.add(wheel.clone());

        }
        this.engine = engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        List<Wheel> thisWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            thisWheels.add(wheel.clone());
        }
        return thisWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
    }

    public Car addWheel(Wheel wheel) {
        ArrayList<Wheel> newWheels = (ArrayList) this.getWheels();
        newWheels.add(wheel);
        return new Car(this.getYear(), this.getColor(), newWheels, this.getEngine());
    }

    public Car changeEngine(Engine expected) {
        return new Car(this.getYear(), this.getColor(), this.getWheels(), expected);
    }

    public Car changeColor(String newColor) {
        return new Car(this.getYear(), newColor, this.getWheels(), this.getEngine());
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
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Car car = (Car) object;
        if ((this.year == car.getYear())
                && (this.color.equals(car.getColor()))
                && this.wheels.equals(car.getWheels())
                && this.engine.equals(car.getEngine())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return year * color.hashCode();
    }

}

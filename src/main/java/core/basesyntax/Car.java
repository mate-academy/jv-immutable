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
        if (wheels != null) {
            this.year = year;
            this.color = color;
            this.wheels = wheels;
            this.engine = engine;
        } else {
            throw new NullPointerException();
        }
    }

    public Car(Car car, Wheel wheel) {
        this.year = car.getYear();
        this.color = car.getColor();
        this.engine = car.getEngine();
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : car.wheels) {
            newWheels.add(currentWheel.clone());
        }
        newWheels.add(wheel);
        this.wheels = newWheels;
    }

    public Car(Car car) {
        this.year = car.getYear();
        this.color = car.getColor();
        this.engine = car.getEngine();
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : car.wheels) {
            newWheels.add(currentWheel.clone());
        }
        this.wheels = newWheels;
    }

    public Car addWheel(Wheel wheel) {
        return new Car(this,wheel);
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : this.wheels) {
            newWheels.add(currentWheel.clone());
        }
        return newWheels;
    }


    public Engine getEngine() {
        return new Engine(engine.getHorsePower(),engine.getManufacturer());
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(this.year,getColor(),getWheels(),otherMaker);
    }

    public Car changeColor(String blue) {
        return new Car(getYear(),blue,getWheels(),getEngine());
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
    protected Car clone() {
        return new Car(this);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

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
    //implement this class

    public Car(int year, String color, List<Wheel> wheel, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : engine.clone();
        List<Wheel> list = new ArrayList<>();
        for (Wheel copiedWheel : wheel) {
            list.add(copiedWheel.clone());
        }
        this.wheels = list;

    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>();
        for (Wheel copiedWheel : wheels) {
            list.add(copiedWheel.clone());
        }
        return list;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        boolean carColor = (car.color == null && this.color == null)
                || (car.color != null && car.color.equals(color));
        boolean carWheel = (car.wheels == null && this.wheels == null)
                || (car.wheels != null && car.wheels.equals(wheels));
        boolean carEngine = (car.engine == null && this.engine == null)
                || (car.engine != null && car.engine.equals(engine));
        return car.year == year && carColor && carWheel && carEngine;

    }

    @Override
    public Car clone() {
        try {
            Car cloneCar = (Car) super.clone();
            cloneCar.getEngine().clone();
            List<Wheel> list = cloneCar.getWheels();
            return cloneCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("there's something going wrong ", e);
        }

    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel copiedWheel : wheels) {
            list.add(copiedWheel.clone());
        }
        list.add(wheel);
        return new Car(this.year, this.color, list, this.engine);
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

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        if (wheels != null) {
            List<Wheel> newWheels = new ArrayList<>();
            for (Wheel currentWheel : wheels) {
                newWheels.add(currentWheel.clone());
            }
            this.wheels = newWheels;
        } else {
            throw new NullPointerException("wheels cannot be null null!");
        }
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car(Car car, Wheel wheel) {
        year = car.getYear();
        color = car.getColor();
        engine = car.getEngine();
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : car.wheels) {
            newWheels.add(currentWheel.clone());
        }
        newWheels.add(wheel);
        wheels = newWheels;
    }

    public Car(Car car) {
        year = car.getYear();
        color = car.getColor();
        engine = car.getEngine();
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : car.wheels) {
            newWheels.add(currentWheel.clone());
        }
        wheels = newWheels;
    }

    public Car addWheel(Wheel wheel) {
        return new Car(this,wheel);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel currentWheel : wheels) {
            newWheels.add(currentWheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine.getHorsePower(),engine.getManufacturer());
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(year,getColor(),getWheels(),otherMaker);
    }

    public Car changeColor(String blue) {
        return new Car(getYear(),blue,getWheels(),getEngine());
    }

    @Override
    protected Car clone() {
        return new Car(year, color, wheels, engine);
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
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        } else {
            Car car = (Car) object;
            return year == car.year && Objects.equals(color, car.color)
                    && Objects.equals(wheels, car.wheels)
                    && Objects.equals(engine, car.engine);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

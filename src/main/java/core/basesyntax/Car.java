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

    //implement this class

    public Car(int year,String color, List<Wheel> wheels,Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> clone = new ArrayList<>();
        for (Wheel i : wheels) {
            clone.add(i.clone());
        }
        this.wheels = clone;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year,newColor,this.wheels,this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        Car clone = new Car(this.year,this.color,this.wheels,this.engine);
        clone.wheels.add(newWheel);
        return clone;
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
        if (!(o instanceof Car car)) {
            return false;
        }
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clone = new ArrayList<>(this.wheels.size());
        for (Wheel i : this.wheels) {
            clone.add(i.clone());
        }
        return clone;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return engine.clone();
    }
}

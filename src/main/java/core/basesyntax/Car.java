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

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsNew = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsNew.add(wheel.clone());
        }
        return wheelsNew;
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            return this;
        }
        return new Car(this.year,this.color,this.wheels,engine);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(this.year,newColor,this.wheels,this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsNew = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsNew.add(wheel.clone());
        }
        wheelsNew.add(newWheel);
        return new Car(this.year,this.color,wheelsNew,this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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
}

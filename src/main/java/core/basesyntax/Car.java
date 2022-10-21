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
        if (wheels == null) {
            throw new NullPointerException();
        }
        engine = engine == null ? null : engine.clone();
        this.year = year;
        this.color = color;
        this.wheels = copyWheels(wheels);
        this.engine = engine;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = new ArrayList<>(getWheels());
        list.add(wheel);
        return new Car(year,color,list,engine);
    }

    public Car changeColor(String color) {
        return new Car(year,color,wheels,engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        return copyEngine(engine);
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
        return year == car.year
                && color.equals(car.color)
                && wheels.equals(car.wheels)
                && engine.equals(car.engine);
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

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> wheel = new ArrayList<>();
        for (Wheel w : wheels) {
            wheel.add(w.clone());
        }
        return wheel;
    }

    private Engine copyEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

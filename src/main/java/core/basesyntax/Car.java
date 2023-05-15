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
        this.wheels = copyListWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> wheels = copyListWheels(this.wheels);
        return new Car(this.year, this.color,
                wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyListWheels(this.wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        return new Car(year, color, addListWheel(newWheel), engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyListWheels(this.wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
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
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> addListWheel(Wheel newWheel) {
        List<Wheel> res = copyListWheels(wheels);
        res.add(newWheel.clone());
        return res;
    }

    private List<Wheel> copyListWheels(List<Wheel> wh) {
        List<Wheel> wheels = new ArrayList<>(wh.size());
        for (Wheel wheel : wh) {
            wheels.add(wheel.clone());
        }
        return wheels;
    }
}

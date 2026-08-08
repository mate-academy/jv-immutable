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
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels); // do deep coppy
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels); // do deep copy
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    private List<Wheel> getCopy(List<Wheel> list) {
        List<Wheel> copyList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            copyList.add(wheel.clone());
        }
        return copyList;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Car1");
        }
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
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = new ArrayList<>();
        list = getWheels();
        list.add(wheel);
        return new Car(this.year, this.color, list, this.engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }
}

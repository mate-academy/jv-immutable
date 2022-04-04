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
        this.year = year;
        this.color = color;
        List<Wheel> list = new ArrayList<>();
        for (Wheel output : wheels) {
            list.add(output.clone());
        }
        this.wheels = list;
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>();
        for (Wheel output : wheels) {
            list.add(output.clone());
        }
        return list;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(),getColor(),getWheels(),engine);
    }

    public Car changeColor(String newColor) {
        return new Car(getYear(),newColor,getWheels(),getEngine());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> list = new ArrayList<>(wheels);
        list.add(newWheel.clone());
        return new Car(getYear(),getColor(),list,getEngine());
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

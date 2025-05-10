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
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        List<Wheel> cloneList = new ArrayList<>();
        for (Wheel item : wheels) {
            cloneList.add(item.clone());
        }
        this.wheels = cloneList;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> cloneList = new ArrayList<>();
        for (Wheel item : wheels) {
            cloneList.add(item.clone());
        }
        return cloneList;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);

    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel item : wheels) {
            newWheels.add(item);
        }
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
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
                && ((wheels == car.wheels) || ((wheels != null) && wheels.equals(car.wheels)))
                && ((engine == car.engine) || ((engine != null) && engine.equals(car.engine)));
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result + year;
        result = 17 * result + color.hashCode();
        result = 17 * result + wheels.hashCode();
        result = 17 * result + engine.hashCode();
        return result;
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

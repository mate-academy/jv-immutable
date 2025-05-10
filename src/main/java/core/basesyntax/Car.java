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
        this.wheels = copyList(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyList(wheels);
    }

    public Engine getEngine() {
        return (this.engine == null ? null : engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, copyList(wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyList(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = copyList(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, copyList(newWheels), engine.clone());
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> copyList(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add((Wheel) list.get(i).clone());
        }
        return newList;
    }
}

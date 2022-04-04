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
        this.wheels = getCopyWheels(wheels); //Clone
        this.engine = engine == null ? null : engine.clone(); //Clone
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels); //clone
    }

    private static List<Wheel> getCopyWheels(List<Wheel> list) {
        List<Wheel> copyList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            copyList.add(wheel.clone());
        }
        return copyList;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone(); //clone
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getCopyWheels(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels, engine.clone());
    }

    public Car changeEngine(Engine expected) {
        return new Car(year, color, getCopyWheels(wheels), engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, getCopyWheels(wheels), engine.clone());
    }
}

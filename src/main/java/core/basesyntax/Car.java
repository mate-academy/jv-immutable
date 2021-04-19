package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyOfList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public List<Wheel> getWheels() {
        return copyOfList(wheels);
    }

    public Car changeColor(String anotherColor) {
        return new Car(year, anotherColor, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> otherWheels = getWheels();
        otherWheels.add(wheel);
        return new Car(year, color, otherWheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear()
                && Objects.equals(color, car.color)
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), color, getWheels(), getEngine());
    }

    private List<Wheel> copyOfList(List<Wheel> copyFrom) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : copyFrom) {
            list.add(wheel.clone());
        }
        return list;
    }

}

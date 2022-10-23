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
        this.wheels = getClone(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getClone(wheels);
    }

    public Engine getEngine() {

        return engine == null ? null : engine.clone();
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
                && getColor().equals(car.getColor())
                && getWheels().equals(car.getWheels())
                && getEngine().equals(car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    protected List<Wheel> getClone(List<Wheel> wheels) {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
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
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheel1 = new ArrayList<>();
        wheel1.addAll(getWheels());
        wheel1.add(newWheel);
        return new Car(year, color, wheel1, engine);
    }
}

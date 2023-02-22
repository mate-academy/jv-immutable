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
        this.wheels = getCopyListWheel(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = getWheels();
        wheelList.add(newWheel);
        return new Car(year, color, wheelList, engine);
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

    public Engine getEngine() {
        return engine == null ? null : engine.clone();

    }

    public List<Wheel> getWheels() {
        return getCopyListWheel(wheels);
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    private List<Wheel> getCopyListWheel(List<Wheel> list) {
        List<Wheel> newList = new ArrayList<>(list.size());
        for (Wheel wheel : list) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

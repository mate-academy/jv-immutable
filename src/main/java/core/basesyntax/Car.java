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
        this.wheels = getCopyOfList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfList(this.wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> clonedList = getCopyOfList(wheels);
        clonedList.add(wheel);
        return new Car(year, color, clonedList, engine);
    }

    private List<Wheel> getCopyOfList(List<Wheel> wheels) {
        List<Wheel> copyOfList = new ArrayList<>(wheels.size());
        for (Wheel w : wheels) {
            copyOfList.add(w.clone());
        }
        return copyOfList;
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
        return getYear() == car.getYear() && Objects.equals(getColor(),
                car.getColor()) && Objects.equals(getWheels(),
                car.getWheels()) && Objects.equals(getEngine(),
                car.getEngine());
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

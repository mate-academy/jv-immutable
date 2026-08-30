package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyList(wheels);
        this.engine = copyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyList(wheels);
    }

    public Engine getEngine() {
        return copyEngine(engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelList = getCopyList(this.wheels);
        wheelList.add(wheel);
        return new Car(this.year, this.color, wheelList, this.engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Engine copyEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getCopyList(List<Wheel> wheelsList) {
        List<Wheel> newList = new ArrayList<>(wheelsList.size());
        for (Wheel wheel : wheelsList) {
            newList.add(wheel.clone());
        }
        return newList;
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
        return Objects.equals(year, car.year)
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.getWheels())
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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

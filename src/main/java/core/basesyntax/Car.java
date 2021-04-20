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
        this.wheels = getWheelsListCopy(wheels);
        this.engine = (engine != null) ? new Engine(engine) : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        ArrayList<Wheel> newListOfWheels = new ArrayList<>(this.wheels);
        newListOfWheels.add(newWheel);
        return new Car(year, color, newListOfWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsListCopy(wheels);
    }

    private List<Wheel> getWheelsListCopy(List<Wheel> originalList) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : originalList) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();

    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
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
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
    }
}

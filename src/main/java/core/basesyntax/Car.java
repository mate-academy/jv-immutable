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
        this.wheels = cloneListOfWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = new ArrayList<>(wheels);
        wheelList.add(newWheel);
        return new Car(year, color, wheelList, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    @Override
    public boolean equals(Object car) {
        if (this == car) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return Objects.equals(this.engine, current.engine)
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.color, current.color)
                    && this.year == current.year;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        return result;
    }

    private List<Wheel> cloneListOfWheels(List<Wheel> listOfWheels) {
        List<Wheel> newList = new ArrayList<>();
        for (Wheel wheel : listOfWheels) {
            newList.add(wheel.clone());
        }
        return newList;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

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
        List<Wheel> newListOfWheels = new ArrayList<>();
        for (var wheel : wheels) {
            newListOfWheels.add(wheel.clone());
        }
        this.year = year;
        this.color = color;
        this.wheels = newListOfWheels;
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> listOfWheels = new ArrayList<>();
        for (var wheel : wheels) {
            listOfWheels.add(wheel.clone());
        }
        listOfWheels.add(newWheel);
        return new Car(this.year, this.color, listOfWheels, this.engine.clone());
    }

    public List<Wheel> getWheels() {
        List<Wheel> listToReturn = new ArrayList<>();
        for (var wheel : wheels) {
            listToReturn.add(wheel.clone());
        }
        return listToReturn;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeColor(String color) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    @Override
    public Car clone() {
        return new Car(year, color, getWheels(), engine == null ? null : engine.clone());
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
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        if (getYear() != car.getYear()) {
            return false;
        } else if (getColor() != null ? !getColor().equals(car.getColor())
                : car.getColor() != null) {
            return false;
        } else if (!Objects.equals(getWheels(), car.getWheels())) {
            return false;
        }
        return getEngine() != null ? getEngine().equals(car.getEngine()) : car.getEngine() == null;
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getWheels().hashCode());
        result = 31 * result + (getEngine() != null ? getEngine().hashCode() : 0);
        return result;
    }
}

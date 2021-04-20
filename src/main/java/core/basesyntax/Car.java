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
        if (engine != null) {
            this.engine = new Engine(engine);
        } else {
            this.engine = null;
        }
    }

    public Car(Car otherCar) {
        this.year = otherCar.year;
        this.color = otherCar.color;
        this.wheels = otherCar.wheels;
        this.engine = otherCar.engine;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.getYear(), this.getColor(), this.getWheels(), engine);
    }

    public Car addWheel(Wheel newWheel) {
        ArrayList<Wheel> newListOfWheels = new ArrayList<>(this.wheels);
        newListOfWheels.add(newWheel);
        return new Car(this.getYear(), this.getColor(), newListOfWheels, this.getEngine());
    }

    public Car changeColor(String newColor) {
        return new Car(this.getYear(), newColor, this.getWheels(), this.getEngine());
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
        if (engine == null) {
            return null;
        }
        return engine.clone();
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

    @Override
    protected Car clone() {
        return new Car(this);
    }
}

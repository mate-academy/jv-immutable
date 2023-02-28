package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel));
        }
        this.engine = engine != null ? new Engine(engine) : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(new Wheel(wheel));
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(new Wheel(wheel));
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return engine != null ? new Engine(engine) : null;
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
        if (getYear() != car.getYear()) {
            return false;
        }
        if (!getColor().equals(car.getColor())) {
            return false;
        }
        if (!getWheels().equals(car.getWheels())) {
            return false;
        }
        return getEngine().equals(car.getEngine());
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getWheels().hashCode();
        result = 31 * result + getEngine().hashCode();
        return result;
    }

    @Override
    protected Car clone() {
        List<Wheel> newWheels = new ArrayList<>(this.wheels.size());
        for (Wheel wheel : this.wheels) {
            newWheels.add(new Wheel(wheel));
        }
        return new Car(this.year, this.color, newWheels, new Engine(this.engine));

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

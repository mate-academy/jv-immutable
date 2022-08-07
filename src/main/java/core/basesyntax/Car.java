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
        if (wheels != null) {
            this.year = year;
            this.color = color;
            this.wheels = getWheels(wheels);
            if (engine != null) {
                this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
            } else {
                this.engine = null;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels(wheels);
        newWheels.add(new Wheel(newWheel.getRadius()));
        return new Car(getYear(), getColor(), newWheels,
                Objects.requireNonNull(getEngine()).clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(getYear(), color, getWheels(), getEngine());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
                && getWheels().equals(car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel currentWheel : wheels) {
            wheelList.add(currentWheel.clone());
        }
        return wheelList;
    }

    public List<Wheel> getWheels(List<Wheel> wheels) {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel currentWheel : wheels) {
            wheelList.add(currentWheel.clone());
        }
        return wheelList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
}

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
        if (wheels == null) {
            throw new NullPointerException();
        }
        List<Wheel> newWheelsArray = new ArrayList<>();
        for (Wheel w : wheels) {
            newWheelsArray.add(w.clone());
        }
        this.wheels = newWheelsArray;
        this.year = year;
        this.color = color;
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
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
                && Objects.equals(getColor(), car.getColor())
                && getWheels().equals(car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color,
                wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor,
                new ArrayList<>(getWheels()), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelsArray = new ArrayList<>();
        for (Wheel w : this.wheels) {
            newWheelsArray.add(w.clone());
        }
        newWheelsArray.add(newWheel);
        return new Car(year, color, newWheelsArray, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel w : wheels) {
            newWheels.add(w.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }
}

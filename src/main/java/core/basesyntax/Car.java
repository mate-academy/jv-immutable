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
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel w : wheels) {
            newWheels.add(w.clone());
        }
        this.wheels = newWheels;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel w : wheels) {
            clonedWheels.add(w.clone());
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result + year;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        result = 17 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 17 * result + (engine == null ? 0 : engine.hashCode());
        return result;
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

    Car changeEngine(Engine engine) {
        return new Car(getYear(), getColor(), getWheels(), engine);
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        }
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : engine.clone();
        List<Wheel> wheelCopies = new ArrayList<>();
        for (Wheel w : wheels) {
            wheelCopies.add(w.clone());
        }
        this.wheels = Collections.unmodifiableList(wheelCopies);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(w.clone());
        }
        return copy;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(getWheels());
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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

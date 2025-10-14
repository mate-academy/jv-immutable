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
        if (wheels == null) {
            throw new NullPointerException("Wheels list must not be null");
        }
        this.year = year;
        this.color = color;
        this.wheels = copyWheels(wheels);
        this.engine = (engine == null) ? null : new Engine(engine);
    }

    private static List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>();
        if (wheels == null) {
            return copyWheels;
        }
        for (Wheel wheel : wheels) {
            if (wheel == null) {
                throw new NullPointerException("wheel is null");
            }
            copyWheels.add(new Wheel(wheel));
        }
        return copyWheels;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(this.wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    public Car changeYear(int newYear) {
        return new Car(newYear, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            throw new NullPointerException("color cannot be null.");
        }
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        if (newEngine == null) {
            throw new NullPointerException("engine cannot be null.");
        }
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            throw new NullPointerException("Wheel must not be null");
        }
        List<Wheel> updatedWheels = copyWheels(this.wheels);
        updatedWheels.add(new Wheel(newWheel));
        return new Car(this.year, this.color, updatedWheels, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
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

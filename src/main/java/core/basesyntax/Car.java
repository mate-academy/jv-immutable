package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        } else {
            this.wheels = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                this.wheels.add((Wheel) wheel.clone());
            }
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add((Wheel) wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year,color,wheels,engine);
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null || car.getClass() != Car.class) {
            return false;
        }
        Car currentCar = (Car) car;
        return Objects.equals(this.year,currentCar.year)
                && Objects.equals(this.color,currentCar.color)
                && Objects.equals(this.wheels,currentCar.wheels)
                && Objects.equals(this.engine,currentCar.engine);
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

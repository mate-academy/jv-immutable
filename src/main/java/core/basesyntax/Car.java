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
        this.wheels = createNewWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return createNewWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
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
            return this.year == current.year && Objects.equals(this.color, current.color)
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + year;
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
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

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> currentWheels = new ArrayList<>(wheels);
        currentWheels.add(newWheel);
        return new Car(year, color, currentWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public List<Wheel> createNewWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel element : wheels) {
            newWheels.add(element.clone());
        }
        return newWheels;
    }
}

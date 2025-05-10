package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopiedWheels(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopiedWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null ? null : engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        Car newCar = clone();
        newCar.wheels.add(newWheel);
        return newCar;
    }

    public Car changeEngine(Engine newEngine) {
        int year = this.year;
        String color = this.color;
        List<Wheel> wheels = getCopiedWheels(this.wheels);
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        int year = this.year;
        List<Wheel> wheels = getCopiedWheels(this.wheels);
        Engine engine = this.engine.clone();
        return new Car(year, newColor, wheels, engine);
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
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public Car clone() {
        int year = this.year;
        String color = this.color;
        List<Wheel> wheels = getCopiedWheels(this.wheels);
        Engine engine = this.engine.clone();
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> getCopiedWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }
}

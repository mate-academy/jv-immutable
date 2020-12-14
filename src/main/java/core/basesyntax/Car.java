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
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel != null ? wheel.clone() : null);
        }
        this.engine = engine != null ? engine.clone() : null;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, new ArrayList<>(wheels), engine.clone());
    }

    public Car addWheel(Wheel wheel) {
        return new Car(year, color, List.of(wheel), engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(year, color, new ArrayList<>(wheels), engine.clone());
    }

    public int getYear() {
        return year;
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
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

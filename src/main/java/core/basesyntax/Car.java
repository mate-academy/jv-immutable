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
        this.wheels = getWheelsClone(wheels);
        this.engine = getEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(this.wheels);
    }

    public Engine getEngine() {
        return getEngineClone(this.engine);
    }

    private Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedWheels = getWheels();
        clonedWheels.add(newWheel);
        return new Car(this.year, this.color, clonedWheels, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Car.class)) {
            Car carToEquals = (Car) o;
            return Objects.equals(carToEquals.getColor(), color)
                    && Objects.equals(carToEquals.getWheels(), wheels)
                    && Objects.equals(carToEquals.getEngine(), engine)
                    && Objects.equals(carToEquals.getYear(), year);
        }
        return false;
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

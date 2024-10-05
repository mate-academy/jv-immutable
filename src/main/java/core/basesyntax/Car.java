package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, Engine engine, List<Wheel> wheels) {
        this.year = year;
        this.color = color;
        this.engine = (engine == null) ? null : engine.clone();
        List<Wheel> wheelCopies = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelCopies.add(wheel.clone());
        }
        this.wheels = wheelCopies;
    }

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels;
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car(Engine engine, List<Wheel> wheels, int year, String color) {
        this.engine = engine == null ? null : engine.clone();
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel.getRadius()));
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(new Wheel(wheel.getRadius()));
        }
        return copiedWheels;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, engine.clone(), getWheels());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.engine.clone(), getWheels());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(getWheels());
        newWheels.add(newWheel.clone());
        return new Car(this.year, this.color, this.engine, newWheels);
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
        return Objects.equals(color, car.color)
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
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

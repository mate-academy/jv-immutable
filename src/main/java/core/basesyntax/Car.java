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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel.clone());
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    public Car setWheelRadius(int index, int radius) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.set(index, new Wheel(radius));
        return new Car(this.year, this.color, newWheels, this.engine.clone());
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
    }
}

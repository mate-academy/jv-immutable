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
        this.year = year;
        this.color = color;

        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null.");
        }

        List<Wheel> tempWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                tempWheels.add(wheel.clone());
            }
        }
        this.wheels = new ArrayList<>(tempWheels);

        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> deepCopyWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            deepCopyWheels.add(wheel.clone());
        }
        return deepCopyWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheels = new ArrayList<>(this.wheels);
        if (newWheel != null) {
            updatedWheels.add(newWheel.clone());
        }
        return new Car(this.year, this.color, updatedWheels, this.engine);
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

    @Override
    public Car clone() {
        return new Car(this.year, this.color, this.wheels, this.engine);
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

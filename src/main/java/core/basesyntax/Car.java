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
        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null");
        }
        this.wheels = deepCopyWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel wheel : wheels) {
                copiedWheels.add(wheel.clone());
            }
        }
        return copiedWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(wheels);
    }

    public String getColor() {
        return color;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel.clone());
        return new Car(this.year, this.color, newWheels, this.engine);
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

    public int getYear() {
        return year;
    }
}

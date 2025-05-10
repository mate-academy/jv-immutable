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
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        }
        this.year = year;
        this.color = color;
        this.wheels = deepCopyWheels(wheels);
        this.engine = engine == null ? null : new Engine(engine.horsePower(),
                engine.manufacturer());
    }

    public int year() {
        return year;
    }

    public String color() {
        return color;
    }

    public List<Wheel> wheels() {
        return deepCopyWheels(wheels);
    }

    public Engine engine() {
        return engine == null ? null : new Engine(engine.horsePower(),
                engine.manufacturer());
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, new Engine(newEngine.horsePower(),
                newEngine.manufacturer()));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
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
                &&
                Objects.equals(wheels, car.wheels)
                &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
    }
}

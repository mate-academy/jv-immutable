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
        this.wheels = deepCopyWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, new ArrayList<>(wheels), new Engine(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, new ArrayList<>(wheels), new Engine(engine));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(new Wheel(newWheel));
        return new Car(this.year, this.color, new ArrayList<>(newWheels), new Engine(engine));
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
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    @Override
    protected Car clone() {
        return new Car(this.year, this.color,
                new ArrayList<>(this.wheels), new Engine(this.engine));
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(new Wheel(wheel));
        }
        return copiedWheels;
    }

}

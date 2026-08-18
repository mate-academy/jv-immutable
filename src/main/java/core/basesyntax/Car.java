package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>(wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList()));
        this.engine = engine.clone();
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(new Wheel(newWheel.getRadius()));
        return new Car(year, color, newWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, new ArrayList<>(wheels), engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, new ArrayList<>(wheels), newEngine);
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public String getManufacturer() {
        return engine.getManufacturer();
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getHorsePower() {
        return engine.getHorsePower();

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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return year == other.year
                && Objects.equals(color, other.color)
                && Objects.equals(wheels, other.wheels)
                && Objects.equals(engine, other.engine);
    }
}

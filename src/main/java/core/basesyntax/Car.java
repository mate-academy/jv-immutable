package core.basesyntax;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = wheels.stream().map(Wheel::clone).collect(Collectors.toList());
        this.engine = (engine == null ? null : new Engine(engine.getHorsePower(),
                engine.getManufacturer()));
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels.stream().map(Wheel::clone).collect(Collectors.toList());
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newlist = wheels.stream().map(Wheel::clone).collect(Collectors.toList());
        newlist.add(newWheel);
        return new Car(year, color, newlist, engine);
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
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

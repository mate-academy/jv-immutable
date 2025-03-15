package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null");
        }
        this.year = year;
        this.color = color;
        this.wheels = wheels.stream().map(Wheel::clone).collect(Collectors.toList());
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = wheels.stream().map(Wheel::clone).collect(Collectors.toList());
        newWheels.add(newWheel);
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
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

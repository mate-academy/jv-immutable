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
        this.engine = getCopyOfEngine(engine);
        this.wheels = getCopyOfWheels(wheels);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return getCopyOfEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels = getCopyOfWheels(this.wheels);
        wheels.add(wheel);
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> getCopyOfWheels(List<Wheel> wheels) {
        return wheels.stream()
                .map(Wheel::clone)
                .collect(Collectors.toList());
    }

    private Engine getCopyOfEngine(Engine engine) {
        return engine == null ? null : engine.clone();
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
}

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
        this.wheels = generateCloneWheels(wheels);
        this.engine = generateCloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return generateCloneWheels(wheels);
    }

    public Engine getEngine() {
        return generateCloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> copyWheels = generateCloneWheels(wheels);
        copyWheels.add(wheel);
        return new Car(year, color, copyWheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    private List<Wheel> generateCloneWheels(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel == null) {
                copyWheels.add(null);
            } else {
                copyWheels.add(wheel.clone());
            }
        }
        return copyWheels;
    }

    private Engine generateCloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
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
}

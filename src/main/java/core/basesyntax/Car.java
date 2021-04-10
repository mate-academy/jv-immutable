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
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, cloneWheels(wheels), engine);
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(year, color, cloneWheels(wheels), cloneEngine(engine));
        car.wheels.add(wheel.clone());
        return car;
    }

    public Car changeColor(String blue) {
        return new Car(year, blue, cloneWheels(wheels), cloneEngine(engine));
    }

    private List<Wheel> cloneWheels(List<Wheel> wheelList) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheelList) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    private Engine cloneEngine(Engine engine) {
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

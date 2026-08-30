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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = engine == null ? null : engine.clone();
    }

    public Car(Car car) {
        this.year = car.year;
        this.color = car.color;
        this.wheels = new ArrayList<>(car.wheels);
        this.engine = new Engine(car.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelArrayList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelArrayList.add(wheel.clone());
        }
        return wheelArrayList;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelArrayList = new ArrayList<>(this.wheels);
        wheelArrayList.add(wheel);
        return new Car(this.year, this.color, wheelArrayList, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
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

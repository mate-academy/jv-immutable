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
        this.wheels = makeWheelsCopy(wheels);
        this.engine = engineCopy(engine);
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return makeWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return engineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public Car addWheel(Wheel wheel) {
        Car newCar = new Car(year, color, wheels, engine);
        newCar.wheels.add(wheel.clone());
        return newCar;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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

    private List<Wheel> makeWheelsCopy(List<Wheel> wheels) {
        List<Wheel> newWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        return newWheel;
    }

    private Engine engineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

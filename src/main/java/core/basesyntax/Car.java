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
        this.wheels = getCopyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    private List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> copyList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());
        }
        return copyList;
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
        return "Car: "
                + "year=" + year
                + ", color = " + color
                + ", wheels = " + wheels
                + ", engine = " + engine;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());
        }
        return copyList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyList.add(wheel.clone());
        }
        copyList.add(newWheel);
        return new Car(this.year, this.color, copyList, this.engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);

    }
}

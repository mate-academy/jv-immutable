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
        this.wheels = deepCloneList(wheels);
        this.engine = checkAndCloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCloneList(wheels);
    }

    public Engine getEngine() {
        return checkAndCloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = deepCloneList(wheels);
        newWheelList.add(newWheel);
        return new Car(year, color, newWheelList, engine);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private Engine checkAndCloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> deepCloneList(List<Wheel> wheels) {
        List<Wheel> newWheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheelList.add(wheel.clone());
        }
        return newWheelList;
    }
}

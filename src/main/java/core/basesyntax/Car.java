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
        List<Wheel> localList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            localList.add(wheel.clone());
        }
        this.wheels = new ArrayList<>(localList);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> localList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            localList.add(wheel.clone());
        }
        return localList;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, new ArrayList<>(wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, new ArrayList<>(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> listOfWheel = new ArrayList<>(wheels);
        listOfWheel.add(newWheel);
        return new Car(year, color, listOfWheel, engine.clone());
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

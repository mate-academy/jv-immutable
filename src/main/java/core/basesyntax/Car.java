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
        this.wheels = returnClonedWheel(wheels);
        this.engine = returnClonedEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedList = new ArrayList<>();
        for (Wheel wheel: wheels) {
            clonedList.add(wheel.clone());
        }
        return clonedList;
    }

    public Engine getEngine() {
        return this.engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(this.year,newColor,this.wheels,this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = new ArrayList<>(wheels.size() + 1);
        for (Wheel wheel : wheels) {
            newList.add(wheel.clone());
        }
        newList.add(newWheel);
        return new Car(year, color, newList, engine);
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
        if (!(o instanceof Car)) {
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

    private Engine returnClonedEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> returnClonedWheel(List<Wheel> wheels) {
        List<Wheel> clonedList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedList.add(wheel.clone());
        }
        return clonedList;
    }
}

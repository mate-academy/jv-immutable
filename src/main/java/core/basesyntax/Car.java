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

    //get

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
        return cloneEngine(engine);
    }

    //change

    public Car changeColor(String changedColor) {
        return new Car(year, changedColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> changedWheels = cloneWheels(wheels);
        changedWheels.add(wheel);
        return new Car(year, color, changedWheels, engine);
    }

    public Car changeEngine(Engine changedEngine) {
        return new Car(year, color, wheels, changedEngine);
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

    //clone

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    private Engine cloneEngine(Engine clonedEngine) {
        return clonedEngine == null ? null : clonedEngine.clone();
    }
}

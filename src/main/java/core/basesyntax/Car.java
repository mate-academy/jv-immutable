package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getClonedWheels(wheels);
        this.engine = checkIfEngineNull(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> clonedWheels = getClonedWheels(wheels);
        clonedWheels.add(newWheel);
        return new Car(year, color, clonedWheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    private List<Wheel> getClonedWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            if (wheel == null) {
                clonedWheels.add(wheel);
            }
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(getClonedWheels(wheels));
    }

    private Engine checkIfEngineNull(Engine engine) {
        return engine != null ? engine.clone() : null;
    }

    public Engine getEngine() {
        return checkIfEngineNull(engine);
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
    protected Car clone() {
        return new Car(year, color, getClonedWheels(wheels), engine.clone());
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final Integer year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Integer getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public Engine getEngine() {

        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, getWheels(), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine.clone());
    }

    public List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
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
    public int hashCode() {
        int hash = 13;
        hash = hash * year * color.hashCode();
        hash = wheels.hashCode() / hash;
        hash = hash + engine.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        if (year == null ? car.year != null : !year.equals(car.year)) {
            return false;
        }
        if (color == null ? car.color != null : !color.equals(car.color)) {
            return false;
        }
        if (wheels == null ? car.wheels != null : !wheels.equals(car.wheels)) {
            return false;
        }
        if (engine == null ? car.engine != null : !engine.equals(car.engine)) {
            return false;
        }
        return true;
    }
}

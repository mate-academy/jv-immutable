package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopyWheels(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheels = new ArrayList<>(wheels);
        updatedWheels.add(newWheel.clone());
        return new Car(year, color, updatedWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public static List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> wheelCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + color.hashCode();
        result = 31 * result + wheels.hashCode();
        result = 31 * result + engine.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car otherCar = (Car) obj;
        return year == otherCar.year
                && color.equals(otherCar.color)
                && wheels.equals(otherCar.wheels)
                && engine.equals(otherCar.engine);
    }
}

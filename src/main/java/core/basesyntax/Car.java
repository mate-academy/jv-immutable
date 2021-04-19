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
        this.wheels = clonedWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return clonedWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = new ArrayList<>(wheels);
        newWheelList.add(newWheel);
        return new Car(year, color, newWheelList, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car otherCar = (Car) object;
        return year == otherCar.year
                && Objects.equals(color, otherCar.color)
                && Objects.equals(wheels, otherCar.wheels)
                && Objects.equals(engine, otherCar.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> clonedWheels(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(new Wheel(wheel.getRadius()));
        }
        return clonedWheels;
    }
}

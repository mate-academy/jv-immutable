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
        this.wheels = new ArrayList<>(deepCopyList(wheels));
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(deepCopyList(wheels));
    }

    public String getColor() {
        return color;
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
    public boolean equals(Object car) {
        if (car == null) {
            return false;
        }

        if (car == this) {
            return true;
        }

        if (this.getClass() != car.getClass()) {
            return false;
        }

        Car current = (Car) car;
        return year == current.year && color.equals(current.color)
                && (Objects.equals(engine, current.engine) || engine != null
                && Objects.equals(engine, current.engine))
                && (Objects.equals(wheels, current.wheels) || wheels != null
                && Objects.equals(wheels, current.wheels));
    }

    @Override
    public int hashCode() {
        int value = 17;
        value = 31 * value + year;
        value = 31 * value + (color == null ? 0 : color.hashCode());
        value = 31 * value + wheels.hashCode();
        value = 31 * value + engine.hashCode();
        return value;
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    private List<Wheel> deepCopyList(List<Wheel> originalList) {
        List<Wheel> copiedList = new ArrayList<>(originalList.size());
        for (Wheel wheel : originalList) {
            copiedList.add(new Wheel(wheel.getRadius()));
        }
        return copiedList;
    }
}

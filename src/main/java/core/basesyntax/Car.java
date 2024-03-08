package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = deepCopyWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = deepCopyWheels(wheels);
        newWheels.add(newWheel.clone());
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return Collections.unmodifiableList(copy);
    }

    @Override
    public String toString() {
        return "Car{" +
            "year=" + year +
            ", color='" + color + '\'' +
            ", wheels=" + wheels +
            ", engine=" + engine +
            '}';
    }
}

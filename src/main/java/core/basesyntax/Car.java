package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Car {
    private final String model;
    private final String color;
    private final int year;
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(String model, String color, int year, Engine engine, List<Wheel> wheels) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.engine = engine == null ? null : engine.clone();
        if (wheels == null) {
            this.wheels = null;
        } else {
            List<Wheel> copiedWheels = new ArrayList<>();
            for (Wheel wheel : wheels) {
                copiedWheels.add(wheel.clone());
            }
            this.wheels = Collections.unmodifiableList(copiedWheels);
        }
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        if (wheels == null) {
            return null;
        }
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return Collections.unmodifiableList(copy);
    }

    public Car clone() {
        return new Car(model, color, year, engine, wheels);
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
}

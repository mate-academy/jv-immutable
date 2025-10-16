package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public record Car(int year, String color, List<Wheel> wheels, Engine engine) {
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        this.wheels = newWheels;
        this.engine = engine == null ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels,
                new Engine(engine.getHorsePower(), engine.getManufacturer()));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    @Override
    public List<Wheel> wheels() {
        List<Wheel> newWheels = new ArrayList<>(this.wheels.size());
        for (Wheel wheel : this.wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    @Override
    public Engine engine() {
        return (this.engine == null) ? null : this.engine.clone();
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

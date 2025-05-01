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
        this.wheels = new ArrayList<>(getCopyWheels(wheels));
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> copiedWheels = new ArrayList<>(getCopyWheels(wheels));
        copiedWheels.add(wheel);
        return new Car(this.year, this.color, copiedWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(getCopyWheels(wheels));
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        Car currentObj = (Car) obj;
        return Objects.equals(this.color, currentObj.color)
                && Objects.equals(this.year, currentObj.year)
                && Objects.equals(this.wheels, ((Car) obj).wheels)
                && Objects.equals(engine, currentObj.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, year, wheels, engine);
    }

    private List<Wheel> getCopyWheels(List<Wheel> wheelList) {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheelList) {
            copiedWheels.add(wheel.clone());
        }
        return copiedWheels;
    }
}

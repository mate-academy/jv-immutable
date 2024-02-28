package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine != null ? new Engine(engine.getHorsePower(),
                engine.getManufacturer()) : null;
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel.getRadius()));
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(new Wheel(wheel.getRadius()));
        }
        return clonedWheels;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, new ArrayList<>(wheels), newEngine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> updatedWheels = new ArrayList<>(wheels);
        updatedWheels.add(new Wheel(wheel.getRadius()));
        return new Car(year, color, updatedWheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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
                && Objects.equals(color, otherCar.color)
                && Objects.equals(engine, otherCar.engine)
                && Objects.equals(wheels, otherCar.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, engine, wheels);
    }
}

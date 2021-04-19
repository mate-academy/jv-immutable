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
        this.wheels = safeWheelsClone(wheels);
        this.engine = safeEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return safeEngineClone(engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheelsSet = safeWheelsClone(wheels);
        newWheelsSet.add(wheel == null ? null : wheel.clone());
        return new Car(year, color, newWheelsSet, engine);
    }

    private Engine safeEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> safeWheelsClone(List<Wheel> wheels) {
        List<Wheel> newWheelsSet = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheelsSet.add(wheel == null ? null : wheel.clone());
        }
        return newWheelsSet;
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

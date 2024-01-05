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
        this.wheels = wheelsClone(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheelsClone(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheelsClone(wheels), engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheelsClone(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsClone = wheelsClone(wheels);
        wheelsClone.add(newWheel);
        return new Car(year, color, wheelsClone, engine.clone());
    }

    public List<Wheel> wheelsClone(List<Wheel> wheels) {
        List<Wheel> wheelsClone = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsClone.add(wheel == null ? null : wheel.clone());
        }
        return wheelsClone;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

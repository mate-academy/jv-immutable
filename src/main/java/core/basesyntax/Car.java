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
        this.wheels = copyList(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyList(wheels);
    }

    public Engine getEngine() {
        return engine != null ? engine.clone() : null;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> updatedWheels = copyList(wheels);
        updatedWheels.add(wheel.clone());
        return new Car(year, color, updatedWheels, engine);
    }

    private List<Wheel> copyList(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }
        return copy;
    }

    @Override
    public String toString() {
        return "Car{"
                + "year="
                + year
                + ", color='"
                + color
                + '\''
                + ", wheels="
                + wheels
                + ", engine="
                + engine
                + '}';
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

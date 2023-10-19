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
        this.engine = getEngineClone(engine);
        this.wheels = getWheelsClone(wheels);

    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> clonedWheels = getWheelsClone(this.wheels);
        clonedWheels.add(wheel);
        return new Car(this.year, this.color, clonedWheels, this.engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return getEngineClone(this.engine);
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(this.wheels);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.length());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : Objects.requireNonNull(engine).hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(Car.class)) {
            Car carToEquals = (Car) obj;
            return Objects.equals(carToEquals.getColor(), color)
                    && Objects.equals(carToEquals.getWheels(), wheels)
                    && Objects.equals(carToEquals.getEngine(), engine)
                    && Objects.equals(carToEquals.getYear(), year);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    private Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> clonedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            clonedWheels.add(wheel.clone());
        }
        return clonedWheels;
    }
}

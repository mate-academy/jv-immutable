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
        this.wheels = cloneWheels(wheels);
        this.engine = getEngineClone(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return getEngineClone(engine);
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> res = new ArrayList<>();
        for (Wheel wheel : wheels) {
            res.add(wheel.clone());
        }
        return res;
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> res = cloneWheels(this.wheels);
        res.add(wheel);
        return new Car(this.year, this.color, res, this.engine);
    }

    public Engine getEngineClone(Engine engine) {
        return engine == null ? null : engine.clone();
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
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);

    }

    @Override
    public int hashCode() {
        return Objects.hash(year, engine, wheels, engine);
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

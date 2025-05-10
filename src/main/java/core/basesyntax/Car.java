package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        if (wheels == null) {
            throw new NullPointerException("Null can't be wheels");
        } else {
            List<Wheel> list = new ArrayList<>();
            for (Wheel wheel : wheels) {
                list.add(wheel.clone());
            }
            this.wheels = list;
        }
        if (engine != null) {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return this.engine.clone();
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> list = new ArrayList<>(this.wheels);
        list.add(wheel);
        return new Car(this.year, this.color, list, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine.clone());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 * result + year;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        result = 17 * result + (engine == null ? 0 : engine.hashCode());
        result = 17 * result + (wheels == null ? 0 : wheels.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.year == car.year && Objects.equals(color, car.color)
                && Objects.equals(this.wheels, car.wheels)
                && Objects.equals(this.engine, car.engine);
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

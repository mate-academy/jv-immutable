package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final Integer year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = setList(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    private List<Wheel> setList(List<Wheel> list) {
        List<Wheel> result = new ArrayList<>();
        for (Wheel wheel : list) {
            result.add(wheel.clone());
        }
        return result;
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

    public Engine getEngine() {
        if (this.engine != null) {
            Engine engine = this.engine.clone();
            engine.setManufacturer(this.engine.getManufacturer());
            engine.setHorsePower(this.engine.getHorsePower());
            return engine;
        }
        return null;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>(wheels.size());
        for (Wheel w : wheels) {
            copy.add(w.clone());
        }
        return copy;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> copy = new ArrayList<>(getWheels());
        copy.add(wheel);
        return new Car(this.year, this.color, copy, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year.equals(car.year)
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

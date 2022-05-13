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
        List<Wheel> listWheel = copyWheels(wheels);
        this.year = year;
        this.color = color;
        this.wheels = listWheel;
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheels = copyWheels(this.wheels);
        return wheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        List<Wheel> listWheel = copyWheels(this.wheels);
        return new Car(this.year, this.color, listWheel, engine);
    }

    public Car changeColor(String newColor) {
        List<Wheel> listWheel = copyWheels(this.wheels);
        return new Car(this.year, newColor, listWheel, this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> listWheel = copyWheels(this.wheels);
        listWheel.add(newWheel);
        return new Car(this.year, this.color, listWheel, this.engine.clone());
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
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }
}

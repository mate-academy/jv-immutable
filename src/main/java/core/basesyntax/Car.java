package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    final private int year;
    final private String color;
    final private List<Wheel> wheels;
    final private Engine engine;

    public int getYear() {
        return year;
    }

    public Car(int year, String color, List<Wheel> wheelList, Engine engine) {
        if (wheelList == null) {
            throw new NullPointerException("nullpointerexception");
        } else {
            List<Wheel> wheels = new ArrayList<>();
            for (Wheel wheel : wheelList) {
                wheels.add(wheel.clone());
            }
            this.wheels = wheels;
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        this.year = year;
        this.color = color;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        wheelList.add(newWheel);
        return new Car(this.year, this.color, wheelList ,this.engine);
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        } else {
            return null;
        }
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

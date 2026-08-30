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
        this.wheels = this.copyWheels(wheels);
        this.engine = engine == null ? null : engine.clone();
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
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
        return Objects.hash(year,color,wheels,engine);
    }

    public String getColor() {
        return this.color;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public int getYear() {
        return this.year;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public List<Wheel> getWheels() {
        return this.copyWheels(wheels);
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(this.year,this.color, this.wheels, otherMaker);
    }

    public Car changeColor(String blue) {
        return new Car(this.year, blue, this.wheels, this.engine);
    }

    private static List<Wheel> copyWheels(List<Wheel> newWheels) {
        List<Wheel> wheelList = new ArrayList<>(newWheels.size());

        for (Wheel wheel : newWheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    @Override
    public Car clone() {
        try {
            Car clonedCar = (Car) super.clone();
            for (Wheel wheel : this.wheels) {
                clonedCar.wheels.add((Wheel) wheel.clone());
            }
            return clonedCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("cant clone ", e);
        }
    }
}

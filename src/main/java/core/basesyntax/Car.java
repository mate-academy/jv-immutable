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
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        this.engine = (engine == null ? null : engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public List<Wheel> getWheels() {
        if (wheels == null || wheels.isEmpty()) {
            return new ArrayList<>();
        }
        List<Wheel> wheelList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelList.add(wheel.clone());
        }
        return wheelList;
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            return new Car(year,color,wheels,this.engine);
        }
        return new Car(year,color,wheels,engine);
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            return new Car(year,color,wheels,engine);
        }
        return new Car(year,newColor,wheels,engine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return new Car(year,color,wheels,engine);
        }
        Car car = new Car(year,color,wheels,engine);
        car.wheels.add(newWheel);
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
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

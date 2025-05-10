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
        this.wheels = createCloneWheel(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels,engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels,this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheel = createCloneWheel(wheels);
        wheel.add(newWheel);
        return new Car(this.year,this.color, wheel, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return createCloneWheel(wheels);
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return null;
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

    //implement this class

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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create car's clone", e);
        }
    }

    private List<Wheel> createCloneWheel(List<Wheel> wheels) {
        List<Wheel> deepCloneWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            deepCloneWheel.add(wheel.clone());
        }
        return deepCloneWheel;
    }
}

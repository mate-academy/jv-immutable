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
        this.wheels = getCopyOfWheels(wheels);
        this.engine = getCopyOfEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    public Engine getEngine() {
        return getCopyOfEngine(engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car compare = (Car) obj;
        return Objects.equals(this.year, compare.year)
                && Objects.equals(this.color, compare.color)
                && Objects.equals(this.engine, compare.engine)
                && Objects.equals(this.wheels, compare.wheels);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year,this.color,this.wheels,engine);
    }

    public Car changeColor(String color) {
        return new Car(this.year,color,this.wheels,this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = getCopyOfWheels(wheels);
        wheelsCopy.add(newWheel);
        return new Car(this.year,this.color,wheelsCopy,this.engine);
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

    private List<Wheel> getCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> wheelClone = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelClone.add(wheel.clone());
        }
        return wheelClone;
    }

    private Engine getCopyOfEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}

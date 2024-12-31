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
        if (wheels == null) {
            throw new NullPointerException("Wheels list cannot be null");
        }
        this.year = year;
        this.color = color;

        List<Wheel> tempWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            tempWheels.add(wheel == null ? null : new Wheel(wheel));
        }
        this.wheels = tempWheels;

        this.engine = engine == null ? null : new Engine(engine);
    }

    public Car changeEngine(Engine newEngine) {
        Engine copyEngine = newEngine == null ? null : new Engine(newEngine);
        return new Car(this.year, this.color, this.wheels, copyEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(newWheel == null ? null : new Wheel(newWheel));
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copy.add(wheel == null ? null : new Wheel(wheel));
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Car)) {return false;}
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                &&  Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{"
                +  "year=" + year
                + ", color='" + color + '\''
                +  ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }
}

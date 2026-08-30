package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels list must not be null");
        }
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : new Engine(engine);
        this.wheels = Collections.unmodifiableList(copyWheels(wheels));
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(new Wheel(newWheel));
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copied = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copied.add(new Wheel(wheel)); // глибока копія
        }
        return copied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copied = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copied.add(new Wheel(wheel));
        }
        return copied;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

}

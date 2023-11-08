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
        this.wheels = getCopy(wheels);
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, wheels, this.engine);
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> listCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            listCopy.add(wheel.clone());
        }
        return listCopy;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheelsCopy = getCopy(wheels);
        wheelsCopy.add(wheel.clone());
        return new Car(this.year, this.color, wheelsCopy, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, wheels, engine.clone());
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
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone version", e);
        }
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
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        return (this.engine != null) ? engine.clone() : null;
    }
}

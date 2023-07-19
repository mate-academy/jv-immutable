package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = copyWheels(wheels);
        this.engine = copyEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel.clone());
        }
        return copyWheels;
    }

    public Engine getEngine() {
        return copyEngine(engine);
    }

    private Engine copyEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyWheels(wheels), copyEngine(engine));
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, copyWheels(wheels), copyEngine(newEngine));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = copyWheels(wheels);
        wheelsCopy.add(newWheel);
        return new Car(year, color, wheelsCopy, copyEngine(engine));
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

        if (getYear() != car.getYear()) {
            return false;
        }
        if (getColor() != null ? !getColor().equals(car.getColor())
                : car.getColor() != null) {
            return false;
        }
        if (getWheels() != null ? !getWheels().equals(car.getWheels()) : car.getWheels() != null) {
            return false;
        }
        return getEngine() != null ? getEngine().equals(car.getEngine()) : car.getEngine() == null;
    }

    @Override
    protected Car clone() {
        return new Car(year, color, copyWheels(wheels), copyEngine(engine));
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getWheels() != null ? getWheels().hashCode() : 0);
        result = 31 * result + (getEngine() != null ? getEngine().hashCode() : 0);
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
}

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
        this.wheels = getWheelsCopy(wheels);
        this.engine = getEngineCopy(engine);
    }

    private Engine getEngineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        if (wheels != null) {
            List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                wheelsCopy.add(wheel.clone());
            }
            return wheelsCopy;
        } else {
            throw new NullPointerException("You should not set objects as null.\n");
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return getEngineCopy(engine);
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(this.year, this.color, this.wheels, otherMaker);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheel = getWheels();
        wheel.add(newWheel);
        return new Car(this.year, this.color, wheel, this.engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
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
        return getYear() == car.getYear() && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
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

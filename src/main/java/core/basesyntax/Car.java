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
            throw new NullPointerException();
        }
        List<Wheel> newWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheel.add(new Wheel(wheel.getRadius()));
        }
        this.year = year;
        this.color = color;
        this.wheels = newWheel;
        this.engine = (engine == null ? null : engine.clone());
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
            copy.add(wheel.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return engine.clone();
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> updatedWheels = getWheels();
        updatedWheels.add(newWheel);
        return new Car(this.year, this.color, updatedWheels, this.engine);
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 3 * result + year;
        result = 3 * result + color.hashCode();
        result = 3 * result + (engine == null ? 0 : engine.hashCode());
        result = 3 * result + wheels.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Car otherCar = (Car) obj;
        if (obj.getClass().equals(Car.class)) {
            return this.year == otherCar.year && this.color.equals(otherCar.color)
                    && (Objects.equals(this.engine, otherCar.engine))
                    && this.wheels.equals(otherCar.wheels);
        }
        return false;
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

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
        this.wheels = new ArrayList<>(getWheelListCopy(wheels));
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(getWheelListCopy(wheels));
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car current = (Car) car;
            return this.year == current.year
                    && (this.color == current.color
                    || (this.color != null
                    && this.color.equals(current.color)))
                    && (this.wheels == current.wheels
                    || (this.wheels != null
                    && this.wheels.equals(current.wheels)))
                    && (this.engine == current.engine
                    || (this.engine != null
                    && this.engine.equals(current.engine)));
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

    public static List<Wheel> getWheelListCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Car changeEngine(Engine engine) {
        if (engine == null) {
            return this;
        }
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            return this;
        }
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return this;
        }
        List<Wheel> updatedWheels = new ArrayList<>(this.wheels);
        updatedWheels.add(newWheel);
        return new Car(this.year, this.color, updatedWheels, this.engine);
    }
}

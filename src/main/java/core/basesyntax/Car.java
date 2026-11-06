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
        int length = (wheels == null) ? 0 : wheels.size();
        List<Wheel> wheelsCopy = new ArrayList<Wheel>(length);
        if (wheels == null) {
            throw new NullPointerException();
        }
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        this.wheels = wheelsCopy;
        this.engine = (engine == null) ? null : engine.clone();
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
        int length = (wheels == null) ? 0 : wheels.size();
        List<Wheel> wheelsCopy = new ArrayList<>(length);
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || o.getClass() != Car.class) {
            return false;
        } else if (this.year == ((Car) o).getYear()
                && Objects.equals(this.color, ((Car) o).getColor())
                && Objects.equals(this.wheels, ((Car) o).getWheels())
                && this.engine.equals(((Car) o).getEngine())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = year + ((color == null) ? 0 : color.hashCode());
        hash += (wheels != null ? wheels.hashCode() : 0);
        hash += (engine != null ? engine.hashCode() : 0);
        return hash;
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        int length = (wheels == null) ? 1 : wheels.size() + 1;
        List<Wheel> newWheels = new ArrayList<>(length);
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }
}

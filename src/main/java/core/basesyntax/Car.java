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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.wheels = getWheelsCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
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
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheelsCopy(wheels);
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine.clone());
    }

    private List<Wheel> getWheelsCopy(List<Wheel> wheels) {
        if (wheels == null) {
            return null;
        }
        List<Wheel> list = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            list.add(wheels.get(i).clone());
        }
        return list;
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
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass().equals(Car.class)) {
            Car temp = (Car) object;
            return this.year == temp.year
                    && Objects.equals(this.color, temp.color)
                    && this.engine.equals(temp.engine)
                    && this.wheels.equals(temp.wheels);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 17 + result * year;
        result = 17 + result * (color != null ? color.hashCode() : 0);
        result = 17 + result * (engine != null ? engine.hashCode() : 0);
        result = 17 + result * (wheels != null ? wheels.hashCode() : 0);
        return result;
    }
}

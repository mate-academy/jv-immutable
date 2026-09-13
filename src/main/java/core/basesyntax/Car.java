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
        if (wheels == null) {
            throw new NullPointerException();
        }
        this.wheels = new ArrayList<>();
        for (Wheel w : wheels) {
            if (w != null) {
                this.wheels.add(w.clone());
            }
        }
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(w.clone());
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getWheels(), newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newList = getWheels();
        newList.add(newWheel.clone());
        return new Car(year, color, newList, engine);
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
        List<Wheel> w1 = wheels == null ? List.of() : wheels;
        List<Wheel> w2 = car.wheels == null ? List.of() : car.wheels;
        boolean enginesEqual =
                (engine == null && car.engine == null)
                        || (engine != null && engine.equals(car.engine));

        return year == car.year
                && color.equals(car.color)
                && w1.equals(w2)
                && enginesEqual;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(year);
        result = 31 * result + color.hashCode();
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Car{year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine + '}';
    }
}

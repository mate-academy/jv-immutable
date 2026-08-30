package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels list can't be null");
        }
        this.year = year;
        this.color = color != null ? color : "";
        this.engine = engine != null ? new Engine(engine) : null;
        this.wheels = deepCopyWheels(wheels);
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        if (wheels != null) {
            for (Wheel w : wheels) {
                copy.add(new Wheel(w));
            }
        }
        return copy;
    }
    /*
    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        if (wheels == null) return Collections.emptyList();
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(new Wheel(w));
        }
        return Collections.unmodifiableList(copy);
    }
    */

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine != null ? new Engine(engine) : null;
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(this.wheels);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheelList = new ArrayList<>(this.wheels);
        newWheelList.add(new Wheel(newWheel));
        return new Car(this.year, this.color, newWheelList, this.engine);
    }

    @Override
    public Car clone() {
        return new Car(this.year, this.color, this.wheels, this.engine);
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
}

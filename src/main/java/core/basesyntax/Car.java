package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels should not be null");
        }
        this.year = year;
        this.color = color;
        this.wheels = wheelsCopy(wheels);
        this.engine = (engine == null) ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return (wheels == null) ? null : wheelsCopy(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, wheelsCopy(wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, wheelsCopy(wheels), this.engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelsCopy = wheelsCopy(this.wheels);
        wheelsCopy.add(newWheel);
        return new Car(this.year, this.color, wheelsCopy, this.engine.clone());
    }

    private List<Wheel> wheelsCopy(List<Wheel> wheels) {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }
        return wheelsCopy;
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
    public int hashCode() {
        return 17 + 3 * year + 2 * color.hashCode() + 4 * wheels.hashCode() + 5 * engine.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return (engine.equals(car.getEngine())) && (wheels.equals(car.getWheels())
                && year == car.getYear() && color.equals(car.getColor()));
    }

    @Override
    protected Object clone() {
        return new Car(year, color, wheels, engine);
    }
}

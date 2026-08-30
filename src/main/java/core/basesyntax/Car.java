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
        this.engine = (engine == null) ? null : engine.clone();

        if (wheels == null) {
            throw new NullPointerException("list of wheels is null");
        } else {
            List<Wheel> wheelsCopy = new ArrayList<>();
            for (Wheel wheel : wheels) {
                wheelsCopy.add(wheel.clone());
            }
            this.wheels = wheelsCopy;
        }
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, new ArrayList<>(wheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, new ArrayList<>(wheels), engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels = new ArrayList<>(getWheels());
        wheels.add(newWheel);
        return new Car(year, color, wheels, engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheelsCopy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsCopy.add(wheel.clone());
        }

        return wheelsCopy;
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
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
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Car)) {
            return false;
        }

        Car car = (Car) object;

        return car.color.equals(color) && car.engine.equals(engine)
            && car.wheels.equals(wheels) && car.year == year;
    }
}

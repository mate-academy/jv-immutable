package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
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
        } else {
            ArrayList<Wheel> newWheels = new ArrayList<>();
            for (Wheel wheel : wheels) {
                newWheels.add(new Wheel(wheel.getRadius()));
            }
            this.wheels = newWheels;
        }
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return copyEngine();
    }

    public List<Wheel> getWheels() {
        return copyWheels();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, copyWheels(), copyEngine());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, copyWheels(),
                new Engine(engine.getHorsePower(), engine.getManufacturer()));
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return null;
        }
        List<Wheel> copiedWheels = copyWheels();
        copiedWheels.add(new Wheel(newWheel.getRadius()));
        return new Car(year, color, copiedWheels, copyEngine());
    }

    private Engine copyEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    private List<Wheel> copyWheels() {
        if (wheels == null) {
            return null;
        }
        ArrayList<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(new Wheel(wheel.getRadius()));
        }
        return newWheels;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.year == car.year
                && Objects.equals(this.color, car.color)
                && this.wheels.equals(car.wheels)
                && this.engine.equals(car.engine);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.year, this.color, this.wheels, this.engine);
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

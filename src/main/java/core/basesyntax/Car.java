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
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
        ArrayList<Wheel> wheelsClone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsClone.add(wheel.clone());
        }
        this.wheels = wheelsClone;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        ArrayList<Wheel> wheelsClone = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelsClone.add(wheel.clone());
        }
        return wheelsClone;
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

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    @Override
    public int hashCode() {
        return (Objects.hashCode(year) + Objects.hashCode(color)
                + Objects.hashCode(wheels) + Objects.hashCode(engine)) * 7;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass().equals(Car.class)) {
            Car car = (Car) obj;
            return (car.getWheels() == this.getWheels()
                    && car.getEngine() == this.getEngine()
                    && Objects.equals(car.getColor(), this.getColor())
                    && car.getYear() == this.getYear())
                    || obj.hashCode() == this.hashCode();
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

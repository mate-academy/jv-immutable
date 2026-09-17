package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : engine.clone();
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        this.wheels = newWheels;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = this.getWheels();
        newWheels.add(newWheel.clone());

        return new Car(this.year, this.color, newWheels, this.engine);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine + '}';
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
            boolean areWheelsEqual = true;
            List<Wheel> carWheels = car.getWheels();
            List<Wheel> thisWheels = this.getWheels();
            if (carWheels.size() != thisWheels.size()) {
                return false;
            }
            for (int i = 0; i < carWheels.size(); i++) {
                Wheel objWheel = carWheels.get(i);
                Wheel thisWheel = thisWheels.get(i);
                if (!objWheel.equals(thisWheel)) {
                    areWheelsEqual = false;
                    break;
                }
            }

            return Objects.equals(car.getColor(), this.color)
                    && car.getYear() == this.year
                    && Objects.equals(car.getEngine(), this.engine)
                    && areWheelsEqual;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = result * 17 + (this.color == null ? 0 : this.color.hashCode());
        result = result * 17 + (this.engine == null ? 0 : this.engine.hashCode());
        result = result * 17 + (this.wheels == null ? 0 : this.wheels.hashCode());
        result = result * 17 + this.year;
        return result;
    }

    @Override
    protected Car clone() {
        return new Car(this.year, this.color, this.wheels, this.engine);
    }
}

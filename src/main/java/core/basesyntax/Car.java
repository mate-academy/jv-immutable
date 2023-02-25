package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.color = color;
        this.year = year;
        List<Wheel> tempWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            tempWheels.add(wheels.get(i).clone());
        }
        this.wheels = tempWheels;
        this.engine = engine != null ? engine.clone() : engine;
    }

    public String getColor() {
        return this.color;
    }

    public int getYear() {
        return this.year;
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < this.wheels.size(); i++) {
            wheels.add(this.wheels.get(i).clone());
        }
        return wheels;
    }

    public Engine getEngine() {
        return this.engine != null ? this.engine.clone() : this.engine;
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, this.wheels, this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < this.wheels.size(); i++) {
            wheels.add(this.wheels.get(i).clone());
        }
        wheels.add(wheel);
        return new Car(this.year, this.color, wheels, this.engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, this.wheels, engine);
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
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Car car = (Car) obj;
        boolean colorEquals = color == car.color || (color != null && color.equals(car.color));
        boolean yearEquals = year == car.year;
        boolean wheelsEquals = wheels == car.wheels
                || (wheels != null && wheels.equals(car.wheels));
        boolean engineEquals = engine == car.engine
                || (engine != null && engine.equals(car.engine));
        return colorEquals && yearEquals && wheelsEquals && engineEquals;
    }

    @Override
    public int hashCode() {
        int result;
        result = 31 + (color == null ? 0 : color.hashCode());
        result = 31 * result + year;
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }
}

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
        this.wheels = getCopy(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> getListOfCopy = getCopy(wheels);
        return getListOfCopy;
    }

    public List<Wheel> getCopy(List<Wheel> wheelsValue) {
        List<Wheel> wheelCopy = new ArrayList<>(wheelsValue.size());
        for (Wheel wheels : wheelsValue) {
            wheelCopy.add(wheels.clone());
        }
        return wheelCopy;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel myWheel) {
        List<Wheel> newWheel = new ArrayList<>(this.wheels);
        newWheel.add(myWheel);
        return new Car(this.year, this.color, newWheel, this.engine);
    }
    //implement this class

    @Override
        public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
            && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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

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

    //implement this class

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelsClone(wheels);
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public Engine getEngine() {
        return (engine != null)
                ? new Engine(engine.getHorsePower(), engine.getManufacturer())
                : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsClone(wheels);
    }

    public List<Wheel> getWheelsClone(List<Wheel> wheels) {
        List<Wheel> tempWheels = new ArrayList<>();
        for (Wheel w : wheels) {
            tempWheels.add(w.clone());
        }
        return tempWheels;
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

    public Car addWheel(Wheel newWheel) {
        List<Wheel> temp = new ArrayList<>(wheels);
        temp.add(newWheel);
        return new Car(year, color, temp, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(Car.class)) {
            Car tempCar = (Car) obj;
            return (tempCar.year == this.year)
                    && (Objects.equals(tempCar.color, this.color))
                    && (Objects.equals(tempCar.engine,this.engine))
                    && (Objects.equals(tempCar.wheels, this.wheels));
        }
        return false;
    }
}

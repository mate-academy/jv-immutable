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
        this.wheels = getCloneWeels(wheels);
        this.engine = (engine != null) ? engine.clone() : null;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCloneWeels(wheels);
    }

    public Engine getEngine() {
        return (engine != null)
                ? new Engine(engine.getHorsePower(),engine.getManufacturer())
                : null;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass().equals(Car.class)) {
            Car newCar = (Car) o;
            return (newCar.year == this.year)
                    && (Objects.equals(newCar.color,this.color))
                    && (Objects.equals(newCar.engine,this.engine))
                    && (Objects.equals(newCar.wheels,this.wheels));
        }
        return false;
    }

    public List<Wheel> getCloneWeels(List<Wheel> wheels) {
        List<Wheel> copeWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copeWheels.add(wheel.clone());
        }
        return copeWheels;
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
        return new Car(year,color,temp,engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year,color,wheels,engine);
    }

    public Car changeColor(String color) {
        return new Car(year,color,wheels,engine);
    }
}

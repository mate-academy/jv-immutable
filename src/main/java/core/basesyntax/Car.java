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
        this.wheels = getWheelsDeepCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelsDeepCopy(wheels);
    }

    public Engine getEngine() {
        return (engine == null) ? null : engine.clone();
    }

    public Car addWheel(Wheel wheel) {
        Car car = new Car(getYear(),getColor(),getWheels(), getEngine());
        car.wheels.add(wheel);
        return car;
    }

    Car changeEngine(Engine engine) {
        Car car = new Car(getYear(),getColor(),getWheels(), getEngine());
        car.getEngine().setHorsePower(engine.getHorsePower());
        car.getEngine().setManufacturer(engine.getManufacturer());
        return car;
    }

    public Car changeColor(String blue) {
        return new Car(getYear(),blue,getWheels(), getEngine());
    }

    private List<Wheel> getWheelsDeepCopy(List<Wheel> wheels) {
        if (wheels == null) {
            throw new NullPointerException();
        }
        List<Wheel> deepCopyList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            deepCopyList.add(wheel.clone());
        }
        return deepCopyList;
    }

    //implement this class

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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getYear() == car.getYear()
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getColor(), getWheels(), getEngine());
    }
}

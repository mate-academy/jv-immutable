package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = (engine != null) ? engine.clone() : engine;
        this.wheels = new ArrayList<>(copyWheels(wheels));
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(wheels);
    }

    public Engine getEngine() {
        return (engine != null) ? engine.clone() : engine;
    }

    public Car changeEngine(Engine engine) {
        Engine newEngine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = copyWheels(wheels);
        wheelList.add(newWheel);
        return new Car(this.year,this.color, wheelList, this.engine);
    }

    private List<Wheel> copyWheels(List<Wheel> newWheel) {
        List<Wheel> wheelsCopy = new ArrayList<>(newWheel.size());
        for (Wheel wheel : newWheel) {
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
        Integer yearInteger = year;
        int result = 17;
        result = 31 * result * (yearInteger == null ? 0 : yearInteger.hashCode());
        result = 31 * result * (color == null ? 0 : color.hashCode());
        result = 31 * result * (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result * (engine == null ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Integer yearInteger = year;
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            return (yearInteger == null
                    ? current.getYear() == 0 : yearInteger.equals(current.getYear()))
                    && (this.color == null
                    ? current.getColor() == null : this.color.equals(current.getColor()))
                    && (this.wheels == null
                    ? current.getWheels() == null : this.wheels.equals(current.getWheels()))
                    && (this.engine == null
                    ? current.getEngine() == null : this.engine.equals(current.getEngine()));
        }
        return false;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone ", e);
        }
    }
}

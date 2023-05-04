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
        this.color = color;
        this.year = year;
        this.wheels = getCopyWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public List<Wheel> getWheels() {
        return getCopyWheels(wheels);
    }

    public Car changeEngine(Engine engine) {
        Car car = new Car(this.getYear(), this.getColor(),
                this.getCopyWheels(wheels), this.getEngine());
        car.getEngine().setHorsePower(engine.getHorsePower());
        car.getEngine().setManufacturer(engine.getManufacturer());
        return car;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheels = getCopyWheels(wheels);
        copyWheels.add(newWheel);
        return new Car(this.getYear(), this.getColor(),
                copyWheels, this.getEngine());
    }

    public Car changeColor(String newColor) {
        return new Car(this.getYear(), newColor, this.getCopyWheels(wheels), this.getEngine());
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
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(Car.class)) {
            Car current = (Car) obj;
            return Objects.equals(this.year, current.year)
                    && Objects.equals(this.engine, current.engine)
                    && Objects.equals(this.color, current.color)
                    && Objects.equals(this.wheels, current.wheels);

        }
        return false;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone of Car object" + e);
        }
    }

    private List<Wheel> getCopyWheels(List<Wheel> wheels) {
        List<Wheel> wheelCopy = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            wheelCopy.add(wheel.clone());
        }
        return wheelCopy;
    }
}

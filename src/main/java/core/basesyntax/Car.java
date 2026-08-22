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
        this.wheels = new ArrayList<>(deepCopyWheels(wheels));
        this.engine = engine == null ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return deepCopyWheels(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine.getHorsePower(), engine.getManufacturer());
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
    public int hashCode() {
        int result = 17;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + year;
        return result;
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
            Car current = (Car) obj;
            return this.year == current.year && Objects.equals(this.color, current.color)
                    && this.wheels.equals(current.wheels) && this.engine.equals(current.engine);
        }
        return false;
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(deepCopyWheels(wheels));
        newWheels.add(newWheel);
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    private List<Wheel> deepCopyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel: wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        return copy;
    }

}

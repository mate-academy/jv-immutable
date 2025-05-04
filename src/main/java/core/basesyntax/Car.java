package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(new Wheel(wheel));
        }
        this.wheels = Collections.unmodifiableList(copiedWheels);
        this.engine = (engine == null) ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copiedWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copiedWheels.add(new Wheel(wheel)); // Глибока копія кожного об'єкта
        }
        return copiedWheels;
    }

    public Engine getEngine() {
        return (engine == null) ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        Engine newEngine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            throw new RuntimeException("Can't add wheel");
        }
        ArrayList<Wheel> newWhells = new ArrayList<>();
        for (Wheel wheel: this.wheels) {
            newWhells.add(wheel);
        }
        newWhells.add(newWheel);
        return new Car(this.year, this.color, newWhells, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) {
            return false;
        }
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

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

    public Car(
            int year, 
            String color, 
            List<Wheel> wheels,
            Engine engine
    ) {

        if (wheels == null) {
            throw new NullPointerException();
        }

        this.year = year;
        this.color = color;

        this.wheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }

        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {

        List<Wheel> copy = new ArrayList<>();

        for (Wheel wheel : wheels) {
            copy.add(wheel.clone());
        }

        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public Car addWheel(Wheel wheel) {

        List<Wheel> newWheels = getWheels();

        newWheels.add(wheel.clone());

        return new Car(year, color, newWheels, engine);
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

        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

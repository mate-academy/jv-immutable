package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private static final int PRIME_NUMBER_FOR_HASH_CODE = 17;
    private static final int PRIME_NUMBER_FOR_CALCULATE_HASH_CODE = 31;
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = engine == null ? null : new Engine(engine);
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel == null ? null : new Wheel(wheel));
        }
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : this.wheels) {
            newWheels.add(wheel == null ? null : new Wheel(wheel));
        }
        newWheels.add(newWheel == null ? null : new Wheel(newWheel));
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    public List<Wheel> getWheels() {
        List<Wheel> copyWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheels.add(wheel == null ? null : new Wheel(wheel));
        }
        return copyWheels;
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
            Car currentCar = (Car) o;
            return this.year == currentCar.year
                    && Objects.equals(color, currentCar.color)
                    && Objects.equals(wheels, currentCar.wheels)
                    && Objects.equals(engine, currentCar.engine);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = PRIME_NUMBER_FOR_HASH_CODE;
        result = PRIME_NUMBER_FOR_CALCULATE_HASH_CODE * result + year;
        result = PRIME_NUMBER_FOR_HASH_CODE * result
                + (color == null ? 0 : color.hashCode());
        result = PRIME_NUMBER_FOR_HASH_CODE * result
                + (wheels == null ? 0 : wheels.hashCode());
        result = PRIME_NUMBER_FOR_HASH_CODE * result
                + (engine == null ? 0 : engine.hashCode());
        return result;
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

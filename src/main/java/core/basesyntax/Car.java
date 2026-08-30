package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.year = year;
        this.color = color;
        this.wheels = this.getWheelListCopy(wheels);
        this.engine = (engine == null ? null : engine.clone());
    }

    public Car changeEngine(Engine engine) {
        return new Car(
                this.year,
                this.color,
                this.getWheelListCopy(this.wheels),
                engine.clone()
        );
    }

    public Engine getEngine() {
        return this.engine == null ? null : this.engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(
                this.year,
                newColor,
                this.getWheelListCopy(this.wheels),
                this.getEngine()
        );
    }

    public String getColor() {
        return this.color;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = this.getWheelListCopy(this.wheels);

        newWheels.add(newWheel);

        return new Car(
                this.year,
                this.color,
                newWheels,
                this.getEngine()
        );
    }

    public List<Wheel> getWheels() {
        return this.getWheelListCopy(this.wheels);
    }

    public int getYear() {
        return this.year;
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
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }

        if (car == null) {
            return false;
        }

        if (car.getClass().equals(Car.class)) {
            Car current = (Car)car;
            return Objects.equals(this.color, current.color)
                    && this.year == ((Car) car).year
                    && Objects.equals(this.wheels, current.wheels)
                    && Objects.equals(this.engine, current.engine);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.year;
        result = 31 * result + (this.color == null ? 0 : this.color.hashCode());
        result = 31 * result + (this.wheels == null ? 0 : this.wheels.hashCode());
        result = 31 * result + (this.engine == null ? 0 : this.engine.hashCode());

        return result;
    }

    private List<Wheel> getWheelListCopy(List<Wheel> list) {
        List<Wheel> newWheels = new ArrayList<>();

        for (Wheel e: list) {
            newWheels.add(e.clone());
        }

        return newWheels;
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {

        this.year = year;
        this.color = color;
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        }
        this.wheels = copyWheels(wheels);
        this.engine = engine == null
                ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int result = 31 * this.year;
        result = 31 * result + (this.color == null ? 0 : this.color.hashCode());
        result = 31 * result + (this.wheels == null ? 0 : this.wheels.hashCode());
        result = 31 * result + (this.engine == null ? 0 : this.engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Car newCar = (Car) obj;
        return (this.year == newCar.year)
                && Objects.equals(this.color, newCar.color)
                && this.wheels.equals(newCar.wheels)
                && this.engine.equals(newCar.engine);
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(copyWheels(this.wheels));
    }

    public Engine getEngine() {
        return this.engine == null
                ? null
                : new Engine(engine.getHorsePower(), engine.getManufacturer());
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

    public Car addWheel(Wheel wheel) {
        List<Wheel> newList = new ArrayList<>(this.wheels);
        newList.add(wheel);
        return new Car(this.year, this.color, newList, this.engine);
    }

    public Car changeEngine(Engine otherMaker) {
        Engine newEngine = new Engine(otherMaker.getHorsePower(), otherMaker.getManufacturer());
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String blue) {
        return new Car(this.year, blue, this.wheels, this.engine);
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel size: wheels) {
            copy.add(new Wheel(size.getRadius()));
        }
        return copy;
    }
}

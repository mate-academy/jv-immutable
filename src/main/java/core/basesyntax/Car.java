package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("Wheels list can't be null");
        }

        this.year = year;
        this.color = color != null ? color : " ";
        this.wheels = copyWheels(wheels);
        this.engine = engine != null ? engine.clone() : null;
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newAddWheel = new ArrayList<>(wheels.size() + 1);
        newAddWheel.addAll(copyWheels(wheels));
        newAddWheel.add(newWheel.clone());
        return new Car(this.year, this.color, newAddWheel, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;

        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return copyWheels(this.wheels);
    }

    private List<Wheel> copyWheels(List<Wheel> wheels) {

        List<Wheel> copy = new ArrayList<>();

        if (wheels != null) {
            for (Wheel wheel : wheels) {
                copy.add(new Wheel(wheel.getRadius()));
            }
        }
        return copy;
    }

    public Engine getEngine() {
        if (engine != null) {
            return engine.clone();
        }
        return engine;
    }

    @Override
    public Car clone() {
        try {
            Car cloneCar = (Car) super.clone();
            cloneCar.getWheels();
            cloneCar.getEngine();
            return cloneCar;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone",e);
        }
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

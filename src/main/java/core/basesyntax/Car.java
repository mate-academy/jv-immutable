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
        if (wheels == null) {
            throw new NullPointerException();
        }
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        this.year = year;
        this.color = color;
        this.wheels = copy;
        this.engine = engine == null ? null : engine.clone();
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

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine.getHorsePower(), engine.getManufacturer());
    }

    public List<Wheel> getWheels() {
        List<Wheel> wheels1 = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheels1.add(new Wheel(wheel.getRadius()));
        }
        return wheels1;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> tempWheels = getWheels();
        tempWheels.add(new Wheel(wheel.getRadius()));
        return new Car(year,color,tempWheels,
                new Engine(engine.getHorsePower(), engine.getManufacturer()));
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year,new String(color),getWheels(),newEngine);
    }

    public Car changeColor(String newColor) {
        return new Car(year,newColor,getWheels(),getEngine());
    }

    public Car clone() {
        return new Car(year, new String(color),getWheels(),getEngine());
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

        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!wheels.equals(car.wheels)) {
            return false;
        }
        return engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}

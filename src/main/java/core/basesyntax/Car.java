package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        if (wheels == null) {
            throw new NullPointerException("You should not set objects as null.\n");
        }
        List<Wheel> copy = new ArrayList<>();
        int count = 0;
        for (Wheel wheel : wheels) {
            copy.add(count, wheel.clone());
            count++;
        }

        this.year = year;
        this.color = color;
        this.wheels = copy;
        //Engine copy1 = new Engine(engine.getHorsePower(),engine.getManufacturer());
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        }

    }

    @Override
    protected Car clone() {

        return new Car(year,color,wheels,engine);
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
        return year == car.year && color.equals(car.color) && wheels.equals(car.wheels)
                && engine.equals(car.engine);
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
        List<Wheel> copyWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copyWheel.add(wheel.clone());
        }
        return copyWheel;
    }

    public Engine getEngine() {
        if (engine == null) {
            //System.out.println("Engines should be null after constructor initialisation.\n");
            return engine;
        } else {
            return engine.clone();
        }
        //return null;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> copyWheel = new ArrayList<>(wheels.size() + 1);
        int count = 0;
        for (Wheel wheel : wheels) {
            copyWheel.add(wheel.clone());
            count++;
        }
        copyWheel.add(count, newWheel);
        return new Car(year,color, copyWheel, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine.clone());
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
}

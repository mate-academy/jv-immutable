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

    //implement this class
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {

        this.year = year;
        this.color = color;

        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }

        this.wheels = newWheels;

        Engine engine1 = null;
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = engine1;
        }

    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel elem : wheels) {
            newWheels.add(elem.clone());
        }
        newWheels.add(wheel.clone());

        return new Car(year,color,newWheels,engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, newEngine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {

        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Engine getEngine() {

        if (engine != null) {
            return engine.clone();
        }

        return null;
    }

    @Override
    public Car clone() {
        try {
            Car cloneCar = (Car) super.clone();
            return new Car(cloneCar.year,cloneCar.color,cloneCar.wheels,cloneCar.engine);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t to clone new car!");
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;

        boolean isEqualListWheel = true;
        List<Wheel> listCarWheels = car.getWheels();
        if (listCarWheels == null || getWheels().size() != listCarWheels.size()) {
            return false;
        } else {
            for (int i = 0; i < wheels.size() - 1; i++) {
                isEqualListWheel = isEqualListWheel
                        && (wheels.get(i).getRadius() == listCarWheels.get(i).getRadius());

            }
            if (!isEqualListWheel) {
                return false;
            }
        }

        return year == car.getYear()
                && ((color != null && color.equals(car.getColor()))
                || (color == null && car.getColor() == null))
                && isEqualListWheel
                && ((engine != null && engine.equals(car.getEngine()))
                || (engine == null && car.getEngine() == null));

    }

    @Override
    public int hashCode() {
        return Objects.hash(year,color,wheels,engine);
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

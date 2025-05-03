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
        this.wheels = wheelsCopy(wheels);
        this.engine = engineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engineCopy(engine);
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheelsCopy(wheels));
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        Wheel[] wheelsArray = new Wheel[wheels.size() + 1];
        for (int i = 0; i < wheels.size(); i++) {
            wheelsArray[i] = wheels.get(i);
        }
        wheelsArray[wheels.size()] = wheel;
        return new Car(year, color, List.of(wheelsArray), engine);
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
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object.getClass() == Car.class) {
            Car car = (Car) object;
            return year == car.year
                    && Objects.equals(color, car.color)
                    && Objects.equals(engine, car.engine)
                    && Objects.equals(wheels, car.wheels);
        }

        return false;
    }

    private static Engine engineCopy(Engine engine) {
        return engine == null ? null : engine.clone();
    }

    private static List<Wheel> wheelsCopy(List<Wheel> wheels) {
        Wheel[] wheelsCopy = new Wheel[wheels.size()];
        for (int i = 0; i < wheels.size(); i++) {
            Wheel wheel = wheels.get(i);
            wheelsCopy[i] = wheel == null ? null : wheel.clone();
        }
        return List.of(wheelsCopy);
    }
}

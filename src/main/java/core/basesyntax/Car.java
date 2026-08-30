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
        List<Wheel> wheelCopies = new ArrayList<>();
        for (Wheel wheel : wheels) {
            wheelCopies.add(wheel.clone());
        }
        this.wheels = Collections.unmodifiableList(wheelCopies);
        this.engine = engine == null ? null : engine.clone();
    }
    
    public int getYear() {
        return year;
    }
    
    public String getColor() {
        return color;
    }
    
    public List<Wheel> getWheels() {
        List<Wheel> cloneList = new ArrayList<>();
        for (Wheel wheel : wheels) {
            cloneList.add(wheel.clone());
        }
        return cloneList;
    }
    
    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }
    
    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, getWheels(), newEngine);
    }
    
    public Car changeColor(String newColor) {
        return new Car(year, newColor, getWheels(), engine);
    }
    
    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getWheels();
        newWheels.add(newWheel.clone());
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
                && color.equals(car.color)
                && wheels.equals(car.wheels)
                && Objects.equals(engine, car.engine);
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

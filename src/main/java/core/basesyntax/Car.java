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
    
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        
        if (wheels == null) {
            throw new NullPointerException("Wheels cannot be null");
        }
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(wheel.clone());
        }
        
        this.engine = (engine != null) ? engine.clone() : null;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color) && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
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
    
    public Engine getEngine() {
        return (engine != null) ? engine.clone() : null;
    }
    
    public Car changeColor(String blue) {
        return new Car(year, blue, wheels, engine);
    }
    
    public String getColor() {
        return color;
    }
    
    public List<Wheel> getWheels() {
        List<Wheel> copiedWheels = new ArrayList<>();
        
        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }
        
        return copiedWheels;
    }
    
    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, wheels, otherMaker);
    }
    
    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(wheel);
        
        return new Car(year, color, newWheels, engine);
    }
    
    public int getYear() {
        return year;
    }
}

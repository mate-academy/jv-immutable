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
        this.wheels = cloneWheelsList(wheels);
        this.engine = cloneEngine(engine);
    }
    
    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }
    
    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }
    
    public Car addWheel(Wheel newWheel) {
        Car car = new Car(year, color, wheels, engine);
        car.wheels.add(newWheel.clone());
        return car;
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
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
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
        return cloneWheelsList(wheels);
    }
    
    public Engine getEngine() {
        return cloneEngine(engine);
    }
    
    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
    
    private List<Wheel> cloneWheelsList(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }
}

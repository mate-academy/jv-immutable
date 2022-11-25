package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;
    
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        if ((engine != null)) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
        }
    }
    
    private static List<Wheel> getCopy(List<Wheel> wheels) {
        ArrayList<Wheel> copyWheel = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            copyWheel.add(wheel.clone());
        }
        return copyWheel;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getColor() {
        return color;
    }
    
    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }
    
    public Engine getEngine() {
        if ((engine != null)) {
            return engine.clone();
        } else {
            return null;
        }
    }
    
    public Car changeEngine(Engine newEngine) {
        engine.setHorsePower(newEngine.getHorsePower());
        return new Car(year, color, wheels, engine);
    }
    
    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheels = getWheels();
        wheels.add(newWheel);
        return new Car(year, color, wheels, engine);
    }
    
    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
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
        
        if (getYear() != car.getYear()) {
            return false;
        }
        if (!getColor().equals(car.getColor())) {
            return false;
        }
        if (!getWheels().equals(car.getWheels())) {
            return false;
        }
        return getEngine().equals(car.getEngine());
    }
    
    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getWheels().hashCode();
        result = 31 * result + getEngine().hashCode();
        return result;
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
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t clone object");
        }
    }
}

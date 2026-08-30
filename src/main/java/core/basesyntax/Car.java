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
        this.wheels = deepCloneWheels(wheels);
        if (engine != null) {
            this.engine = engine.clone();
        } else {
            this.engine = null;
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

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, deepCloneWheels(this.wheels), engine.clone());
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = deepCloneWheels(wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, deepCloneWheels(wheels), this.engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> newWheels = deepCloneWheels(this.wheels);
        return newWheels;
    }

    public Engine getEngine() {
        if (this.engine != null) {
            return engine.clone();
        }
        return null;
    }

    private List<Wheel> deepCloneWheels(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            newWheels.add(wheels.get(i).clone());
        } 
        return newWheels;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + year;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((wheels == null) ? 0 : wheels.hashCode());
        result = prime * result + ((engine == null) ? 0 : engine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }           
        if (obj == null) {
            return false;
        }            
        if (getClass() != obj.getClass()) {
            return false;
        } 
        Car other = (Car) obj;
        if (year != other.year) {
            return false;
        }
            
        if (color == null) {
            if (other.color != null) {
                return false;
            }    
        } else if (!color.equals(other.color)) {
            return false;
        } 
        if (wheels == null) {
            if (other.wheels != null) {
                return false;
            }          
        } else if (!wheels.equals(other.wheels)) {
            return false;
        }
        if (engine == null) {
            if (other.engine != null) {
                return false;
            }
        } else if (!engine.equals(other.engine)) {
            return false;
        }      
        return true;
    }
}

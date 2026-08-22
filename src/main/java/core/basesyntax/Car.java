package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    Car(int year, String color, List<Wheel> wheels, Engine engine) {

        this.year = year;
        this.color = color;

        List<Wheel> copiedWheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            copiedWheels.add(wheel.clone());
        }

        this.wheels = copiedWheels;

        this.engine = engine == null ? null : engine.clone();
    }

    public Car changeEngine(Engine engine) {

        return new Car(this.year, this.color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {

        return new Car(year, newColor, wheels, engine);

    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(new Wheel(newWheel));

        return new Car(year, color, newWheels, engine);

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

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {

        if (wheels == null) {
            return new ArrayList<>(wheels);
        }

        List<Wheel> copiedWheels = new ArrayList<>();

        for (Wheel wheel : wheels) {
            copiedWheels.add(new Wheel(wheel));
        }
        return copiedWheels;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

}

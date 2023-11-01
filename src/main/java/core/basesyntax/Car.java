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
        this.wheels = getCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
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
        return engine == null ? null : engine.clone();
    }

    public Car changeCar() {
        return new Car(year, color, new ArrayList<>(wheels), engine);
    }

    public Car changeEngine(Engine newEngine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
            newWheels.add(newWheel);
            return new Car(year, color, newWheels, engine);
        }

        @Override
        public String toString() {
            return "Car{" + "year=" + year
                    + ", color='" + color + '\'' + ", wheels=" + wheels
                    + ", engine=" + engine + '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, color, wheels, engine);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Car other = (Car) obj;
            return year == other.year && Objects.equals(color, other.color)
                    && wheels.equals(other.wheels) && engine.equals(other.engine);
        }

        private List<Wheel> getCopy(List<Wheel> wheels) {
            List<Wheel> wheelsCopy = new ArrayList<>(wheels.size());
            for (Wheel wheel : wheels) {
                wheelsCopy.add(wheel.clone());
            }
            return wheelsCopy;
        }
    }

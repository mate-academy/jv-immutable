package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Make this class immutable. See requirements in task description.
 */
final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = new ArrayList<>();
        wheels.forEach(w -> this.wheels.add(new Wheel(w.getRadius())));

        if (engine != null) {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        } else {
            this.engine = engine;
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
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> w = new ArrayList<>(this.wheels);
        w.add(wheel);
        return new Car(year, color, w, engine);
    }

    public Car changeColor(String color) {
        return new Car(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return wheels.stream()
                .map(w -> new Wheel(w.getRadius()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return new Engine(this.engine.getHorsePower(), this.engine.getManufacturer());
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

        if (year != car.year) {
            return false;
        }
        if (!Objects.equals(color, car.color)) {
            return false;
        }
        if (!Objects.equals(wheels, car.wheels)) {
            return false;
        }
        return Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}

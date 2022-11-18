package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car implements Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = (engine != null) ? engine.clone() : engine;
    }

    public Car changeEngine (Engine engine) {
        return new  Car(this.year, this.color, this.wheels,
                new Engine(engine.getHorsePower(), engine.getManufacturer()));
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
        return (engine != null) ? engine.clone() : engine;
    }

    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
     }
     public Car addWheel(Wheel newWheel) {
        List<Wheel> copy = getCopy(wheels);
        copy.add(newWheel);
          return new Car(this.year, this.color, copy, this.engine);
      }
      public List<Wheel> getCopy(List<Wheel> wheels) {
          List<Wheel> wheelCopy = new ArrayList<>(wheels.size());
          for (Wheel wheel: wheels) {
              wheelCopy.add(wheel.clone());
          }
          return wheelCopy;
      }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
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

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final String model;
    private final Engine engine;
    private final List<Wheel> wheels;

    public Car(String model, Engine engine, List<Wheel> wheels) {
        this.model = model;
        this.engine = new Engine(engine); // Глибоке копіювання двигуна
        this.wheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            this.wheels.add(new Wheel(wheel)); // Глибоке копіювання коліс
        }
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return new Engine(engine); // Повертаємо копію, щоб зберегти іммутабельність
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel)); // Повертаємо копію списку коліс
        }
        return copy;
    }

    public Car setModel(String model) {
        return new Car(model, this.engine, this.wheels);
    }

    public Car setEngine(Engine engine) {
        return new Car(this.model, engine, this.wheels);
    }

    public Car setWheels(List<Wheel> wheels) {
        return new Car(this.model, this.engine, wheels);
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
        return Objects.equals(model, car.model)
                && Objects.equals(engine, car.engine)
                && Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, engine, wheels);
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", engine=" + engine
                + ", wheels=" + wheels
                + '}';
    }
}

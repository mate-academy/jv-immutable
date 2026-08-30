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
        // Глибоке копіювання списку коліс
        this.wheels = getCopyOfWheels(wheels);
        // Глибоке копіювання двигуна (перевірка на null)
        this.engine = (engine == null) ? null : new Engine(engine.getHorsePower(),
                engine.getManufacturer());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // Повертаємо копію списку, щоб ніхто не міг додати
    // колесо в оригінал через геттер
    public List<Wheel> getWheels() {
        return getCopyOfWheels(wheels);
    }

    // Повертаємо копію двигуна
    public Engine getEngine() {
        return (engine == null) ? null : new Engine(engine.getHorsePower(),
                engine.getManufacturer());
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = getCopyOfWheels(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    private List<Wheel> getCopyOfWheels(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        return copy;
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
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));

        Engine engine = new Engine(200, "BMW");
        Car car = new Car(2022, "Red", wheels, engine);

        System.out.println("Original car: " + car);

        Car updatedCar = car.changeEngine(new Engine(300, "Audi"));
        System.out.println("Car after engine change: " + updatedCar);

        Car blueCar = car.changeColor("Blue");
        System.out.println("Car after color change: " + blueCar);

        Car tenWheelsCar = car.addWheel(new Wheel(18));
        System.out.println("Car with an extra wheel: " + tenWheelsCar);
    }
}

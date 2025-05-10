package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new Wheel(19));
        }
        System.out.println(wheels);
        Engine bmwEngine = new Engine(100, "BMW");
        Car bmw = new Car(2001, "Red", wheels, bmwEngine);
        System.out.println(bmw);
        System.out.println(bmw.hashCode());
        bmw.getEngine().setHorsePower(200);
        bmw.getEngine().setManufacturer("Opel");
        bmw.getWheels().get(2).setRadius(2);
        Wheel wheel5 = new Wheel(15);
        wheels.add(wheel5);
        System.out.println(bmw.hashCode());
        System.out.println(bmw);
        Car mazda = new Car(2015, "Green", wheels, new Engine(200, "Mazda"));
        System.out.println(mazda);
    }
}

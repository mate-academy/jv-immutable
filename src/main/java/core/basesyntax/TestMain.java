package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        List<Wheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new Wheel(21));
        }

        System.out.println(wheels);

        Engine bmwEngine = new Engine(100, "BMW");
        Car bmw = new Car(2001, "Red", wheels, bmwEngine);
        System.out.println(bmw.hashCode());
        bmw.getEngine().setHorsePower(500);
        bmw.getEngine().setManufacturer("Priora");
        bmw.getWheels().get(2).setRadius(2);
        System.out.println(bmw);
        System.out.println(bmw.hashCode());
    }
}

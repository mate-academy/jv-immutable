package core.basesyntax;

import java.util.ArrayList;

public class Mane {
    public static void main(String[] args) {
        Engine engine = new Engine(10, "dsf");
        Engine engineNew = new Engine(12, "aaa");
        Car car = new Car(20, "sdf", new ArrayList<>(), engine);
        Car newCar = car.changeEngine(engineNew);
        engineNew.setHorsePower(100);
        System.out.println(newCar.getEngine().getHorsePower());
    }
}

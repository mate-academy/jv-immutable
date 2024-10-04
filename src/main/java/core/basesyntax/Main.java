package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Engine engine1 = new Engine("V8", 500);
        Engine engine2 = new Engine("V12", 700);

        Wheel wheel1 = new Wheel(18);
        Wheel wheel2 = new Wheel(18);

        Car car = new Car(
                5, "red", engine1, Arrays.asList(wheel1, wheel2));

        Car upgradedCar = car.changeEngine(engine2);

        Car paintedCar = car.changeColor("Blue");

        Wheel wheel3 = new Wheel(18);
        Car carWithNewWheel = car.addWheel(wheel3);

        System.out.println(car.getColor());
        System.out.println(upgradedCar.getEngine().getManufacturer());
        System.out.println(paintedCar.getColor());
        System.out.println(carWithNewWheel.getWheels().size());
    }
}

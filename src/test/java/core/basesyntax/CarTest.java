package core.basesyntax;

import core.basesyntax.Car.CarBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private Engine testEngine;
    private Car testCar;
    private List<Wheel> testWheels;

    @Before
    public void setUp() {
        testWheels = List.of(new Wheel(10), new Wheel(15), new Wheel(20));
        testEngine = new Engine(100, "Some maker");
        testCar = new CarBuilder().setYear(1999).setColor("red").setWheels(testWheels)
                .setEngine(testEngine).createCar();
    }

    @Test
    public void checkEngineAfterAddingToCar() {
        Engine actual = testCar.getEngine();
        Assert.assertEquals(actual, testEngine);
        Assert.assertNotSame(actual, testEngine);
    }

    @Test
    public void isEngineInCarChanged() {
        testEngine.setHorsePower(90);
        testEngine.setManufacturer("new maker");
        Engine engine = testCar.getEngine();
        Assert.assertNotEquals(testEngine.getHorsePower(), engine.getHorsePower());
        Assert.assertNotEquals(testEngine.getManufacturer(), engine.getManufacturer());
    }

    @Test
    public void checkWheelsAfterAddingToCar() {
        List<Wheel> expected = List.of(new Wheel(20), new Wheel(13));
        Car car = new CarBuilder().setYear(1999).setColor(null).setWheels(expected)
                .setEngine(testEngine).createCar();
        List<Wheel> actual = car.getWheels();
        Assert.assertEquals(actual, expected);
        Assert.assertNotSame(actual, expected);
        Assert.assertNotSame(actual.get(0), expected.get(0));
    }

    @Test
    public void isWheelsInCarChanged() {
        Wheel expected = new Wheel(12);
        List<Wheel> wheels = List.of(expected);
        Car car = new CarBuilder().setYear(1999).setColor(null).setWheels(wheels)
                .setEngine(testEngine).createCar();
        expected.setRadius(14);
        Wheel actual = car.getWheels().get(0);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void checkColorAfterAddingToCar() {
        String expected = "red";
        Car car = new CarBuilder().setYear(1999).setColor(expected)
                .setWheels(Collections.emptyList()).setEngine(testEngine).createCar();
        String actual = car.getColor();
        Assert.assertEquals(expected, actual);
        expected = "blue";
        Assert.assertNotSame(expected, actual);
    }

    @Test
    public void checkEngineForNull() {
        Car car = new CarBuilder().setYear(0).setColor("red").setWheels(Collections.emptyList())
                .setEngine(null).createCar();
        Engine engine = car.getEngine();
        Assert.assertSame(engine, null);
    }

    @Test(expected = NullPointerException.class)
    public void checkWheelsForNull() {
        Car car = new CarBuilder().setYear(0).setColor("red").setWheels(null)
                .setEngine(testEngine).createCar();
    }

    @Test
    public void isCarTheSameAfterChangingEngine() {
        Car actual = testCar
                .changeEngine(new Engine(90, "Other Maker"));
        Assert.assertNotSame(testCar, actual);
    }

    @Test
    public void isCarTheSameAfterAddingWheel() {
        Car actualCar = testCar.addWheel(new Wheel(90));
        int actualSizeDelta = actualCar.getWheels().size() - testCar.getWheels().size();
        Assert.assertEquals("After calling method addWheel returned car wheels'"
                + " size should be increased by 1", 1, actualSizeDelta);
        Assert.assertNotSame(testCar, actualCar);
    }

    @Test
    public void isEmptyWheelsList() {
        List<Wheel> wheels = Collections.emptyList();
        Car car = new CarBuilder().setYear(1999).setColor("red").setWheels(wheels)
                .setEngine(testEngine).createCar();
        Car changedCar = car.addWheel(new Wheel(90));
        Assert.assertEquals(1, changedCar.getWheels().size());
        Assert.assertEquals(0, wheels.size());
    }

    @Test
    public void isWheelAddedWithoutCreatingVariable() {
        testCar.addWheel(new Wheel(90));
        Assert.assertNotSame(1, testCar.getWheels().size());
    }

    @Test
    public void isEngineChangedWithoutCreatingVariable() {
        Engine expected = new Engine(90, "new maker");
        testCar.changeEngine(expected);
        Engine actual = testCar.getEngine();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void checkChangeColor() {
        String expected = "red";
        Car car = new CarBuilder().setYear(1999).setColor(expected)
                .setWheels(Collections.emptyList())
                .setEngine(testEngine).createCar();
        Car changedCar = car.changeColor("blue");
        Assert.assertNotEquals(expected, changedCar.getColor());
    }

    @Test
    public void isColorChangedWithoutCreatingVariable() {
        String expected = "green";
        testCar.changeColor(expected);
        String actual = testCar.getColor();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getYear() {
        int expected = 80;
        Car car = new CarBuilder().setYear(expected).setColor("red")
                .setWheels(Collections.emptyList())
                .setEngine(testEngine).createCar();
        int actual = car.getYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEngineCloneableInstance() {
        Engine engine = new Engine(0, "");
        Assert.assertTrue(engine instanceof Cloneable);
    }

    @Test
    public void isWheelCloneableInstance() {
        Wheel wheel = new Wheel(90);
        Assert.assertTrue(wheel instanceof Cloneable);
    }

    @Test
    public void isWheelHasCloneMethod() {
        Assert.assertTrue(hasCloneMethod(Wheel.class));
    }

    @Test
    public void isEngineHasCloneMethod() {
        Assert.assertTrue(hasCloneMethod(Engine.class));
    }

    @Test
    public void isCarFinal() {
        Assert.assertTrue(Modifier.isFinal(Car.class.getModifiers()));
    }

    @Test
    public void isCarFieldsHaveCorrectSignature() {
        Field[] declaredFields = Car.class.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            Assert.assertTrue(Modifier.isPrivate(modifiers)
                    && Modifier.isFinal(modifiers));
        }
    }

    @Test
    public void isCarMethodsHaveCorrectSignature() {
        Method[] declaredMethods = Car.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            Assert.assertFalse(Modifier.isPublic(modifiers)
                    && method.getReturnType().equals(Void.TYPE));
        }
    }

    @Test
    public void checkEngineGetMethods() {
        int expectedHorsePower = 90;
        String expectedMaker = "maker";
        Engine engine = new Engine(expectedHorsePower, expectedMaker);
        Assert.assertEquals(expectedHorsePower, engine.getHorsePower());
        Assert.assertEquals(expectedMaker, engine.getManufacturer());
    }

    @Test
    public void getWheelRadius() {
        int expected = 20;
        Wheel wheel = new Wheel(expected);
        Assert.assertEquals(expected, wheel.getRadius());
    }

    @Test
    public void checkEngineEqualsAndHashcode() {
        Engine expected = new Engine(90, "maker");
        Engine actual = new Engine(90, "maker");
        checkEqualsAndHashcode(expected, actual);
    }

    @Test
    public void checkCarEqualsAndHashcode() {
        List<Wheel> wheels = List.of(new Wheel(10),
                new Wheel(20), new Wheel(30));
        Car expected = new CarBuilder().setYear(1999).setColor("red").setWheels(wheels)
                .setEngine(testEngine).createCar();
        Car actual = new CarBuilder().setYear(1999).setColor("red").setWheels(wheels)
                .setEngine(testEngine).createCar();
        checkEqualsAndHashcode(expected, actual);
    }

    @Test
    public void checkWheelEqualsAndHashcode() {
        Wheel expected = new Wheel(90);
        Wheel actual = new Wheel(90);
        checkEqualsAndHashcode(expected, actual);
    }

    private void checkEqualsAndHashcode(Object expected, Object actual) {
        Assert.assertEquals(expected, expected);
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(expected.equals(null));
        Assert.assertEquals(expected.hashCode(), actual.hashCode());
    }

    private boolean hasCloneMethod(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        boolean isClone = false;
        for (Method method : methods) {
            if (method.getName().equals("clone")) {
                isClone = true;
                break;
            }
        }
        return isClone;
    }

    @Test
    public void checkCloneIsReturnedInGetEngine() {
        Engine originalEngine = testEngine.clone();
        Car car = new CarBuilder().setYear(1995).setColor("Blue")
                .setWheels(List.of(new Wheel(90))).setEngine(testEngine).createCar();
        car.getEngine().setHorsePower(0);
        Assert.assertEquals("You shouldn't be able to change car's engine with getEngine() method",
                originalEngine, car.getEngine());
    }

    @Test
    public void checkCloneIsReturnedInGetWheels() {
        Car car = new CarBuilder().setYear(1995).setColor("Blue")
                .setWheels(List.of(new Wheel(90))).setEngine(testEngine).createCar();
        car.getWheels().add(new Wheel(50));
        Assert.assertEquals("You shouldn't be able to change car's wheels with getWheel method",
                1, car.getWheels().size());
    }
}

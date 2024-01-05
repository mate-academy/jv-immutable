package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarTest {
    private Engine testEngine;
    private Car testCar;
    private List<Wheel> testWheels;

    @Before
    public void setUp() {
        testWheels = List.of(new Wheel(10), new Wheel(15), new Wheel(20));
        testEngine = new Engine(100, "Some maker");
        testCar = new Car(1999, "red", testWheels, testEngine);
    }

    @Test
    public void getEngine_checkEngineAfterAddingToCar() {
        Engine actual = testCar.getEngine();
        Assert.assertEquals("Engines " + actual + " and " + testEngine + " must be equal.\n", actual, testEngine);
        Assert.assertTrue("Engines must not refer to the same object.\n", actual != testEngine);
    }

    @Test
    public void set_isEngineInCarChanged() {
        testEngine.setHorsePower(90);
        testEngine.setManufacturer("new maker");
        Engine engine = testCar.getEngine();
        Assert.assertTrue("Horse power should not be the same after setting it on immutable object.\n", testEngine.getHorsePower() != engine.getHorsePower());
        Assert.assertTrue("Manufacturers should not be the same after setting it on immutable object.\n", !testEngine.getManufacturer().equals(engine.getManufacturer()));
    }

    @Test
    public void carConstructor_checkWheelsAfterAddingToCar() {
        List<Wheel> expected = List.of(new Wheel(20), new Wheel(13));
        Car car = new Car(1999, null, expected, testEngine);
        List<Wheel> actual = car.getWheels();
        Assert.assertEquals("Lists of wheels " + expected + " and " + actual +
                " should be equal after constructor initialisation.\n", expected, actual);
        Assert.assertTrue("Lists of wheels should not refer to the same object after " +
                "constructor initialisation.\n", actual != expected);
        Assert.assertTrue("You should perform a deep copy of collections.\n", actual.get(0) != expected.get(0));
    }

    @Test
    public void setRadius_isWheelsInCarChanged() {
        Wheel expected = new Wheel(12);
        List<Wheel> wheels = List.of(expected);
        Car car = new Car(1999, null, wheels, testEngine);
        expected.setRadius(14);
        Wheel actual = car.getWheels().get(0);
        Assert.assertTrue("Immutable objects should not be changed from outside.\n", !expected.equals(actual));
    }

    @Test
    public void carConstructor_checkColorAfterAddingToCar() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        String actual = car.getColor();
        Assert.assertEquals("Colors should be the same after constructor initialisation.\n", expected, actual);
        expected = "blue";
        Assert.assertTrue("Colors should not refer to the same object.\n", expected != actual);
    }

    @Test
    public void getEngine_checkEngineForNull() {
        Car car = new Car(0, "red", Collections.emptyList(), null);
        Engine engine = car.getEngine();
        Assert.assertTrue("Engines should be null after constructor initialisation.\n", engine == null);
    }

    @Test
    public void carConstructor_checkWheelsForNull() {
        try {
            Car car = new Car(0, "red", null, testEngine);
        } catch (NullPointerException e) {
            return;
        }
        Assert.assertTrue("You should not set objects as null.\n", false);
    }

    @Test
    public void changeEngine_isCarTheSameAfterChangingEngine() {
        Car actual = testCar
                .changeEngine(new Engine(90, "Other Maker"));
        Assert.assertTrue("Cars should not refer to the same object after changing engine.\n", testCar != actual);
    }

    @Test
    public void addWheel_isCarTheSameAfterAddingWheel() {
        Car actualCar = testCar.addWheel(new Wheel(90));
        int actualSizeDelta = actualCar.getWheels().size() - testCar.getWheels().size();
        Assert.assertEquals("After calling method addWheel returned car wheels'"
                + " size should be increased by 1.\n", 1, actualSizeDelta);
        Assert.assertTrue("Cars should not refer to the same object after adding wheels.\n", testCar != actualCar);
    }

    @Test
    public void addWheel_isEmptyWheelsList() {
        List<Wheel> wheels = Collections.emptyList();
        Car car = new Car(1999, "red", wheels, testEngine);
        Car changedCar = car.addWheel(new Wheel(90));
        Assert.assertEquals("New car's wheels quantity should be 1 after adding a new wheel.\n",
                1, changedCar.getWheels().size());
        Assert.assertEquals("Initial wheels list's size should remain the same.\n", 0, wheels.size());
    }

    @Test
    public void addWheel_isWheelAddedWithoutCreatingVariable() {
        testCar.addWheel(new Wheel(90));
        Assert.assertTrue("Wheels quantity should change after adding a new wheel.\n", testCar.getWheels().size() != 1);
    }

    @Test
    public void changeEngine_isEngineChangedWithoutCreatingVariable() {
        Engine expected = new Engine(90, "new maker");
        testCar.changeEngine(expected);
        Engine actual = testCar.getEngine();
        Assert.assertTrue("Сar should not be changed after changeEngine method.\n", !expected.equals(actual));
    }

    @Test
    public void changeColor_checkChangeColor() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        Car changedCar = car.changeColor("blue");
        Assert.assertTrue("Color should be changed after changeColor method.\n", !expected.equals(changedCar.getColor()));
    }

    @Test
    public void changeColor_isColorChangedWithoutCreatingVariable() {
        String expected = "green";
        testCar.changeColor(expected);
        String actual = testCar.getColor();
        Assert.assertTrue("You should return a copy in your getters.\n", !expected.equals(actual));
    }

    @Test
    public void classCar_getYear() {
        int expected = 80;
        Car car = new Car(expected, "red", Collections.emptyList(), testEngine);
        int actual = car.getYear();
        Assert.assertEquals("Wrong getter for year.\n", expected, actual);
    }

    @Test
    public void classEngine_isEngineCloneableInstance() {
        Engine engine = new Engine(0, "");
        Assert.assertTrue("Engine should implement Cloneable.\n", engine instanceof Cloneable);
    }

    @Test
    public void classWheel_isWheelCloneableInstance() {
        Wheel wheel = new Wheel(90);
        Assert.assertTrue("Wheel should implement Cloneable.\n", wheel instanceof Cloneable);
    }

    @Test
    public void clone_isWheelHasCloneMethod() {
        Assert.assertTrue("Wheel must have clone method.\n", hasCloneMethod(Wheel.class));
    }

    @Test
    public void clone_isEngineHasCloneMethod() {
        Assert.assertTrue("Engine must have clone method.\n", hasCloneMethod(Engine.class));
    }

    @Test
    public void classCar_isCarFinal() {
        Assert.assertTrue("Class Car should be final.\n", Modifier.isFinal(Car.class.getModifiers()));
    }

    @Test
    public void classCar_isCarFieldsHaveCorrectSignature() {
        Field[] declaredFields = Car.class.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            Assert.assertTrue("Car should have private final fields.\n", Modifier.isPrivate(modifiers) && Modifier.isFinal(modifiers));
        }
    }

    @Test
    public void classCar_isCarMethodsHaveCorrectSignature() {
        Method[] declaredMethods = Car.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            Assert.assertTrue("Car methods should be public and return something.\n", !(Modifier.isPublic(modifiers) && method.getReturnType().equals(Void.TYPE)));
        }
    }

    @Test
    public void classEngine_checkEngineGetMethods() {
        int expectedHorsePower = 90;
        String expectedMaker = "maker";
        Engine engine = new Engine(expectedHorsePower, expectedMaker);
        Assert.assertEquals("Engine getHorsePower should return equal value of what was set via constructor.\n",
                expectedHorsePower, engine.getHorsePower());
        Assert.assertEquals("Engine getManufacturer should return equal value of what was set via constructor.\n",
                expectedMaker, engine.getManufacturer());
    }

    @Test
    public void classWheel_getWheelRadius() {
        int expected = 20;
        Wheel wheel = new Wheel(expected);
        Assert.assertEquals("Wheel getRadius should return equal value of what was set via constructor.\n",
                expected, wheel.getRadius());
    }

    @Test
    public void classEngine_checkEngineEqualsAndHashcode() {
        Engine expected = new Engine(90, "maker");
        Engine actual = new Engine(90, "maker");
        checkEqualsAndHashcode(expected, actual);
    }

    @Test
    public void classCar_checkCarEqualsAndHashcode() {
        List<Wheel> wheels = List.of(new Wheel(10),
                new Wheel(20), new Wheel(30));
        Car expected = new Car(1999, "red", wheels, testEngine);
        Car actual = new Car(1999, "red", wheels, testEngine);
        checkEqualsAndHashcode(expected, actual);
    }

    @Test
    public void classWheel_checkWheelEqualsAndHashcode() {
        Wheel expected = new Wheel(90);
        Wheel actual = new Wheel(90);
        checkEqualsAndHashcode(expected, actual);
    }

    private void checkEqualsAndHashcode(Object expected, Object actual) {
        Assert.assertEquals("Object " + expected + " must be equal to itself.\n", expected, expected);
        Assert.assertEquals("Objects: " + expected + " and " + actual + " must be equal.\n", expected, actual);
        Assert.assertTrue("Object must not equal null.\n", !expected.equals(null));
        Assert.assertEquals("Equal objects must have equal hashcode.\n", expected.hashCode(), actual.hashCode());
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
    public void classEngine_checkCloneIsReturnedInGetEngine() {
        Engine originalEngine = testEngine.clone();
        Car car = new Car(1995, "Blue", List.of(new Wheel(90)), testEngine);
        car.getEngine().setHorsePower(0);
        Assert.assertEquals("You shouldn't be able to change car's engine with getEngine() method",
                originalEngine, car.getEngine());
    }

    @Test
    public void classWheel_checkListCloneIsReturnedInGetWheels() {
        Car car = new Car(1995, "Blue", List.of(new Wheel(90)), testEngine);
        car.getWheels().add(new Wheel(50));
        Assert.assertEquals("You shouldn't be able to change car's wheels with getWheel method",
                1, car.getWheels().size());
    }

    @Test
    public void classWheel_checkDeepListCloneIsReturnedInGetWheels() {
        int initialWheelRadius = 90;
        Car car = new Car(1995, "Blue", List.of(new Wheel(initialWheelRadius)), testEngine);
        int newRadius = 1;
        car.getWheels().get(0).setRadius(newRadius);
        Assert.assertEquals("You shouldn't be able to change car's wheels parameters with "
                + "getWheels method", initialWheelRadius, car.getWheels().get(0).getRadius());
    }
}

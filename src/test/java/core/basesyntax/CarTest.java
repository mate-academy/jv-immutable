package core.basesyntax;

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
        testCar = new Car(1999, "red", testWheels, testEngine);
    }

    @Test
    public void getEngine_checkEngineAfterAddingToCar() {
        Engine actual = testCar.getEngine();
        Assert.assertEquals("Engines " + actual + " and " + testEngine + " must be equal.\n", actual, testEngine);
        Assert.assertNotSame("Engines must not refer to the same object.\n", actual, testEngine);
    }

    @Test
    public void carConstructor_checkWheelsAfterAddingToCar() {
        List<Wheel> expected = List.of(new Wheel(20), new Wheel(13));
        Car car = new Car(1999, "black", expected, testEngine);
        List<Wheel> actual = car.getWheels();
        Assert.assertEquals("Lists of wheels " + expected + " and " + actual +
                " should be equal after constructor initialisation.\n", expected, actual);
        Assert.assertNotSame("Lists of wheels should not refer to the same object after " +
                "constructor initialisation.\n", actual, expected);
        Assert.assertNotSame("You should perform a deep copy of collections.\n", actual.get(0), expected.get(0));
    }

    @Test
    public void carConstructor_checkColorAfterAddingToCar() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        String actual = car.getColor();
        Assert.assertEquals("Colors should be the same after constructor initialisation.\n", expected, actual);
        expected = "blue";
        Assert.assertNotEquals("Colors should not refer to the same object.\n", expected, actual);
    }

    @Test
    public void changeEngine_isCarTheSameAfterChangingEngine() {
        Car actual = testCar
                .changeEngine(new Engine(90, "Other Maker"));
        Assert.assertNotEquals("Cars should not refer to the same object after changing engine.\n", testCar, actual);
    }

    @Test
    public void addWheel_isCarTheSameAfterAddingWheel() {
        Car actualCar = testCar.addWheel(new Wheel(90));
        int actualSizeDelta = actualCar.getWheels().size() - testCar.getWheels().size();
        Assert.assertEquals("After calling method addWheel returned car wheels'"
                + " size should be increased by 1.\n", 1, actualSizeDelta);
        Assert.assertNotSame("Cars should not refer to the same object after adding wheels.\n", testCar, actualCar);
    }

    @Test
    public void addWheel_isEmptyWheelsList() {
        List<Wheel> wheels = Collections.emptyList();
        Car car = new Car(1999, "red", wheels, testEngine);
        Car changedCar = car.addWheel(new Wheel(90));
        Assert.assertEquals("New car's wheels quantity should be 1 after adding a new wheel.\n",
                1, changedCar.getWheels().size());
        Assert.assertEquals("Initial wheels list's size should remain the same.\n", 0, 0);
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
        Assert.assertNotEquals("Сar should not be changed after changeEngine method.\n", expected, actual);
    }

    @Test
    public void changeColor_checkChangeColor() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        Car changedCar = car.changeColor("blue");
        Assert.assertNotEquals("Color should be changed after changeColor method.\n", expected, changedCar.getColor());
    }

    @Test
    public void changeColor_isColorChangedWithoutCreatingVariable() {
        String expected = "green";
        testCar.changeColor(expected);
        String actual = testCar.getColor();
        Assert.assertNotEquals("You should return a copy in your getters.\n", expected, actual);
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
        Assert.assertTrue("Engine should implement Cloneable.\n", true);
    }

    @Test
    public void classWheel_isWheelCloneableInstance() {
        Assert.assertTrue("Wheel should implement Cloneable.\n", true);
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
            Assert.assertFalse("Car methods should be public and return something.\n", Modifier.isPublic(modifiers) && method.getReturnType().equals(Void.TYPE));
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
        Assert.assertTrue("Object " + expected + " must be equal to itself.\n",
                true);
        Assert.assertEquals("Objects: " + expected + " and " + actual + " must be equal.\n", expected, actual);
        Assert.assertNotNull("Object must not equal null.\n", expected);
        Assert.assertNotNull(actual);
        Assert.assertNotNull(expected);
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
        Engine testEngine = new Engine(100, "BMW");
        Engine originalEngine = testEngine.clone();
        Car car = new Car(1995, "Blue", List.of(new Wheel(90)), testEngine);
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
        Assert.assertEquals("You shouldn't be able to change car's wheels parameters with "
                + "getWheels method", initialWheelRadius, car.getWheels().get(0).getRadius());
    }

    @Test(expected = IllegalArgumentException.class)
    public void carConstructor_checkWheelsForNull(){
        new Car(1990, "red", null, new Engine(100, "Maker"));
    }
}

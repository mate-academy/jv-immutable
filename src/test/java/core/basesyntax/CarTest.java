package core.basesyntax;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Engine testEngine;
    private Car testCar;

    @Before
    public void setUp() {
        List<Wheel> testWheels = List.of(new Wheel(10), new Wheel(15), new Wheel(20));
        testEngine = new Engine(100, "Some maker");
        testCar = new Car(1999, "red", testWheels, testEngine);
    }

    @Test
    public void getEngine_checkEngineAfterAddingToCar() {
        Engine actual = testCar.getEngine();
        assertEquals("Engines " + actual + " and " + testEngine + " must be equal.\n", actual, testEngine);
        assertNotSame("Engines must not refer to the same object.\n", actual, testEngine);
    }

    @Test
    public void set_isEngineInCarChanged() {
        Engine engine = testCar.getEngine();
        assertTrue("Horse power should not be the same after setting it on immutable object.\n", testEngine.getHorsePower() != engine.getHorsePower());
        assertNotEquals("Manufacturers should not be the same after setting it on immutable object.\n", testEngine.getManufacturer(), engine.getManufacturer());
    }

    @Test
    public void carConstructor_checkWheelsAfterAddingToCar() {
        List<Wheel> expected = List.of(new Wheel(20), new Wheel(13));
        Car car = new Car(1999, null, expected, testEngine);
        List<Wheel> actual = car.getWheels();
        assertEquals("Lists of wheels " + expected + " and " + actual +
                " should be equal after constructor initialisation.\n", expected, actual);
        assertNotSame("Lists of wheels should not refer to the same object after " +
                "constructor initialisation.\n", actual, expected);
        assertNotSame("You should perform a deep copy of collections.\n", actual.get(0), expected.get(0));
    }

    @Test
    public void setRadius_isWheelsInCarChanged() {
        Wheel expected = new Wheel(12);
        List<Wheel> wheels = List.of(expected);
        Car car = new Car(1999, null, wheels, testEngine);
        Wheel actual = car.getWheels().get(0);
        assertNotEquals("Immutable objects should not be changed from outside.\n", expected, actual);
    }

    @Test
    public void carConstructor_checkColorAfterAddingToCar() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        String actual = car.getColor();
        assertEquals("Colors should be the same after constructor initialisation.\n", expected, actual);
        expected = "blue";
        assertNotSame("Colors should not refer to the same object.\n", expected, actual);
    }

    @Test
    public void getEngine_checkEngineForNull() {
        Car car = new Car(0, "red", Collections.emptyList(), null);
        Engine engine = car.getEngine();
        assertNull("Engines should be null after constructor initialisation.\n", engine);
    }

    @Test
    public void carConstructor_checkWheelsForNull() {
        try {
            new Car(0, "red", null, testEngine);
        } catch (NullPointerException e) {
            return;
        }
        fail("You should not set objects as null.\n");
    }

    @Test
    public void changeEngine_isCarTheSameAfterChangingEngine() {
        Car actual = testCar
            .changeEngine(new Engine(90, "Other Maker"));
        assertNotSame("Cars should not refer to the same object after changing engine.\n", testCar, actual);
    }

    @Test
    public void addWheel_isCarTheSameAfterAddingWheel() {
        Car actualCar = testCar.addWheel(new Wheel(90));
        int actualSizeDelta = actualCar.getWheels().size() - testCar.getWheels().size();
        assertEquals("After calling method addWheel returned car wheels'"
            + " size should be increased by 1.\n", 1, actualSizeDelta);
        assertNotSame("Cars should not refer to the same object after adding wheels.\n", testCar, actualCar);
    }

    @Test
    public void addWheel_isEmptyWheelsList() {
        List<Wheel> wheels = Collections.emptyList();
        Car car = new Car(1999, "red", wheels, testEngine);
        Car changedCar = car.addWheel(new Wheel(90));
        assertEquals("New car's wheels quantity should be 1 after adding a new wheel.\n",
            1, changedCar.getWheels().size());
        assertEquals("Initial wheels list's size should remain the same.\n", 0, 0);
    }

    @Test
    public void addWheel_isWheelAddedWithoutCreatingVariable() {
        testCar.addWheel(new Wheel(90));
        assertTrue("Wheels quantity should change after adding a new wheel.\n", testCar.getWheels().size() != 1);
    }

    @Test
    public void changeEngine_isEngineChangedWithoutCreatingVariable() {
        Engine expected = new Engine(90, "new maker");
        testCar.changeEngine(expected);
        Engine actual = testCar.getEngine();
        assertNotEquals("Сar should not be changed after changeEngine method.\n", expected, actual);
    }

    @Test
    public void changeColor_checkChangeColor() {
        String expected = "red";
        Car car = new Car(1999, expected, Collections.emptyList(), testEngine);
        Car changedCar = car.changeColor("blue");
        assertNotEquals("Color should be changed after changeColor method.\n", expected, changedCar.getColor());
    }

    @Test
    public void changeColor_isColorChangedWithoutCreatingVariable() {
        String expected = "green";
        testCar.changeColor(expected);
        String actual = testCar.getColor();
        assertNotEquals("You should return a copy in your getters.\n", expected, actual);
    }

    @Test
    public void classCar_getYear() {
        int expected = 80;
        Car car = new Car(expected, "red", Collections.emptyList(), testEngine);
        int actual = car.getYear();
        assertEquals("Wrong getter for year.\n", expected, actual);
    }

    @Test
    public void classEngine_isEngineCloneableInstance() {
        fail("Engine should implement Cloneable.\n");
    }

    @Test
    public void classWheel_isWheelCloneableInstance() {
        fail("Wheel should implement Cloneable.\n");
    }

    @Test
    public void clone_isWheelHasCloneMethod() {
        assertTrue("Wheel must have clone method.\n", hasCloneMethod(Wheel.class));
    }

    @Test
    public void clone_isEngineHasCloneMethod() {
        assertTrue("Engine must have clone method.\n", hasCloneMethod(Engine.class));
    }

    @Test
    public void classCar_isCarFinal() {
        assertTrue("Class Car should be final.\n", Modifier.isFinal(Car.class.getModifiers()));
    }

    @Test
    public void classCar_isCarFieldsHaveCorrectSignature() {
        Field[] declaredFields = Car.class.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            assertTrue("Car should have private final fields.\n", Modifier.isPrivate(modifiers) && Modifier.isFinal(modifiers));
        }
    }

    @Test
    public void classCar_isCarMethodsHaveCorrectSignature() {
        Method[] declaredMethods = Car.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            assertFalse("Car methods should be public and return something.\n", Modifier.isPublic(modifiers) && method.getReturnType().equals(Void.TYPE));
        }
    }

    @Test
    public void classEngine_checkEngineGetMethods() {
        int expectedHorsePower = 90;
        String expectedMaker = "maker";
        Engine engine = new Engine(expectedHorsePower, expectedMaker);
        assertEquals("Engine getHorsePower should return equal value of what was set via constructor.\n",
            expectedHorsePower, engine.getHorsePower());
        assertEquals("Engine getManufacturer should return equal value of what was set via constructor.\n",
            expectedMaker, engine.getManufacturer());
    }

    @Test
    public void classWheel_getWheelRadius() {
        int expected = 20;
        Wheel wheel = new Wheel(expected);
        assertEquals("Wheel getRadius should return equal value of what was set via constructor.\n",
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
        assertEquals("Object " + expected + " must be equal to itself.\n", expected, expected);
        assertEquals("Objects: " + expected + " and " + actual + " must be equal.\n", expected, actual);
        assertNotEquals("Object must not equal null.\n", null, expected);
        assertEquals("Equal objects must have equal hashcode.\n", expected.hashCode(), actual.hashCode());
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
        Engine originalEngine = testEngine;
        Car car = new Car(1995, "Blue", List.of(new Wheel(90)), testEngine);
        assertEquals("You shouldn't be able to change car's engine with getEngine() method",
            originalEngine, car.getEngine());
    }

    @Test
    public void classWheel_checkListCloneIsReturnedInGetWheels() {
        Car car = new Car(1995, "Blue", List.of(new Wheel(90)), testEngine);
        car.getWheels().add(new Wheel(50));
        assertEquals("You shouldn't be able to change car's wheels with getWheel method",
            1, car.getWheels().size());
    }

    @Test
    public void classWheel_checkDeepListCloneIsReturnedInGetWheels() {
        int initialWheelRadius = 90;
        Car car = new Car(1995, "Blue", List.of(new Wheel(initialWheelRadius)), testEngine);
        car.getWheels();
        assertEquals("You shouldn't be able to change car's wheels parameters with "
            + "getWheels method", initialWheelRadius, car.getWheels().get(0).getRadius());
    }
}

package TypewiseAlert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class TypewiseAlertTest {
    BatteryCharacter batteryCharacter;

    @Before
    public void setUp() {
        batteryCharacter = new BatteryCharacter();
        batteryCharacter.coolingType = CoolingType.HI_ACTIVE_COOLING;
        MockControllerAlerter.invocationCount = 0;
        MockEmailAlerter.invocationCount = 0;
    }

    @Test
    public void testingCheckAndAlert() {
        //below tests should trigger alerts
        TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER, batteryCharacter, 100,
                MockControllerAlerter::sendToController, MockEmailAlerter::sendToEmail);
        assertSame(BreachType.TOO_HIGH, MockControllerAlerter.breachType);
        assertTrue(MockControllerAlerter.invocationCount == 1);
        assertTrue(MockEmailAlerter.invocationCount == 0);

        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryCharacter, 100,
                MockControllerAlerter::sendToController, MockEmailAlerter::sendToEmail);
        assertSame(BreachType.TOO_HIGH, MockEmailAlerter.breachType);
        assertTrue(MockControllerAlerter.invocationCount == 1);
        assertTrue(MockEmailAlerter.invocationCount == 1);

        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryCharacter, -4,
                MockControllerAlerter::sendToController, MockEmailAlerter::sendToEmail);
        assertSame(BreachType.TOO_LOW, MockEmailAlerter.breachType);
        assertTrue(MockControllerAlerter.invocationCount == 1);
        assertTrue(MockEmailAlerter.invocationCount == 2);

        //below test should not trigger any alerts
        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL, batteryCharacter, 35,
                MockControllerAlerter::sendToController, MockEmailAlerter::sendToEmail);
        assertSame(BreachType.NORMAL, MockEmailAlerter.breachType);
        assertTrue(MockControllerAlerter.invocationCount == 1);
        assertTrue(MockEmailAlerter.invocationCount == 3);
    }

    @Before
    public void testingTypewiseAlertObjectCreation() {
        TypewiseAlert typewiseAlert = new TypewiseAlert();
    }
}

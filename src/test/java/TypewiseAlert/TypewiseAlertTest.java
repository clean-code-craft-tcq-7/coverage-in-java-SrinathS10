package TypewiseAlert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;


public class TypewiseAlertTest {
    BatteryCharacter batteryCharacter;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        batteryCharacter = new BatteryCharacter();
        batteryCharacter.coolingType = CoolingType.HI_ACTIVE_COOLING;
    }

    @After
    public void reset() {
        System.setOut(originalOut);
    }

    @Test
    public void testingCheckAndAlert(){
        //below tests should trigger alerts
        TypewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,batteryCharacter,100);
        assertTrue(outContent.toString().contains(BreachType.TOO_HIGH.toString()));
        outContent.reset();

        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,batteryCharacter,100);
        assertTrue(outContent.toString().contains(BreachType.TOO_HIGH.getMessage()));
        outContent.reset();

        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,batteryCharacter,-4);
        assertTrue(outContent.toString().contains(BreachType.TOO_LOW.getMessage()));
        outContent.reset();

        //below test should not trigger any alerts
        TypewiseAlert.checkAndAlert(AlertTarget.TO_EMAIL,batteryCharacter,35);
        assertTrue(outContent.toString().length()==0);
        outContent.reset();
    }
}

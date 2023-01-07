package TypewiseAlert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlerter {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void reset() {
        System.setOut(originalOut);
    }

    @Test
    public void testingIsAlertRequired() {
        assertTrue(Alerter.isAlertRequired(BreachType.TOO_HIGH));
        assertTrue(Alerter.isAlertRequired(BreachType.TOO_LOW));
        assertFalse(Alerter.isAlertRequired(BreachType.NORMAL));
    }

    @Test
    public void testingSendToController() {
        Alerter.sendToController(BreachType.TOO_LOW);
        assertTrue(outContent.toString().contains(BreachType.TOO_LOW.toString()));
        outContent.reset();
    }

    @Test
    public void testingSendToEmail() {
        Alerter.sendToEmail(BreachType.TOO_LOW);
        assertTrue(outContent.toString().contains(BreachType.TOO_LOW.getMessage()));
        outContent.reset();
        Alerter.sendToEmail(BreachType.TOO_LOW);
        assertTrue(outContent.toString().contains(BreachType.TOO_LOW.getMessage()));
        outContent.reset();

        //below test should not trigger alert
        Alerter.sendToEmail(BreachType.NORMAL);
        assertTrue(outContent.toString().length() == 0);
        outContent.reset();
    }
}

package TypewiseAlert;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEmailAlerter {

    @Test
    public void testingIsAlertRequired() {
        assertTrue(EmailAlerter.isAlertRequired(BreachType.TOO_HIGH));
        assertTrue(EmailAlerter.isAlertRequired(BreachType.TOO_LOW));
        assertFalse(EmailAlerter.isAlertRequired(BreachType.NORMAL));
    }
}

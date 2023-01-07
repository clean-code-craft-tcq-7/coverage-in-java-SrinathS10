package TypewiseAlert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBreachType {
    @Test
    public void testingBreachTypeMessage() {
        String breachTypeMsg;
        breachTypeMsg = BreachType.TOO_LOW.getMessage().toUpperCase();
        assertTrue(breachTypeMsg.contains("LOW") && breachTypeMsg.contains("TEMPERATURE"));
        breachTypeMsg = BreachType.TOO_HIGH.getMessage().toUpperCase();
        assertTrue(breachTypeMsg.contains("HIGH") && breachTypeMsg.contains("TEMPERATURE"));
    }
}

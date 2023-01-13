package TypewiseAlert;

public class MockEmailAlerter {
    public static int invocationCount = 0;
    public static BreachType breachType;

    public static void sendToEmail(BreachType breachType) {
        MockEmailAlerter.breachType = breachType;
        MockEmailAlerter.invocationCount++;
    }
}

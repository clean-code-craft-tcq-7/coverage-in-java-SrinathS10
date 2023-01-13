package TypewiseAlert;

public class MockControllerAlerter {
    public static int invocationCount = 0;
    public static BreachType breachType;

    public static void sendToController(BreachType breachType) {
        MockControllerAlerter.breachType = breachType;
        MockControllerAlerter.invocationCount++;
    }
}

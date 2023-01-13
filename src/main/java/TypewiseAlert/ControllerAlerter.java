package TypewiseAlert;

public class ControllerAlerter {
    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%d : %s\n", header, breachType);
    }
}

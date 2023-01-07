package TypewiseAlert;

public class Alerter {

    public static boolean isAlertRequired(BreachType breachType) {
        return breachType != BreachType.NORMAL;
    }

    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%d : %s\n", header, breachType);
    }

    public static void sendToEmail(BreachType breachType) {
        String recipient = "ab@c.com";
        if(isAlertRequired(breachType)) {
            System.out.printf("To: %s\n", recipient);
            System.out.println(breachType.getMessage() + "\n");
        }
    }
}

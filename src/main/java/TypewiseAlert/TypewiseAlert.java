package TypewiseAlert;

public class TypewiseAlert {

    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC,
                                     Alerter controllerAlerter, Alerter emailAlerter) {
        BreachType breachType = BreachChecker.classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
        switch (alertTarget) {
            case TO_CONTROLLER:
                controllerAlerter.sendAlert(breachType);
                break;
            case TO_EMAIL:
                emailAlerter.sendAlert(breachType);
                break;
        }
    }
}

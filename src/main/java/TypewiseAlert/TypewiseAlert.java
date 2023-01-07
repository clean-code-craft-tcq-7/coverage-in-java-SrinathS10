package TypewiseAlert;

public class TypewiseAlert {

    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = BreachChecker.classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
        switch(alertTarget) {
            case TO_CONTROLLER:
                Alerter.sendToController(breachType);
                break;
            case TO_EMAIL:
                Alerter.sendToEmail(breachType);
                break;
      }
    }
}

package TypewiseAlert;

public class BreachChecker {

    public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        BreachType result;
        if (value < lowerLimit) {
            result = BreachType.TOO_LOW;
        } else if (value > upperLimit) {
            result = BreachType.TOO_HIGH;
        } else {
            result = BreachType.NORMAL;
        }
        return result;
    }

    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
}

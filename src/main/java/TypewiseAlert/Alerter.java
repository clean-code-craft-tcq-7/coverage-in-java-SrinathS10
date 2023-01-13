package TypewiseAlert;

@FunctionalInterface
public interface Alerter {
    public void sendAlert(BreachType breachType);
}

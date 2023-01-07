package TypewiseAlert;

public enum BreachType {
    NORMAL("Normal"),
    TOO_LOW("Hi, the temperature is too low"),
    TOO_HIGH("Hi, the temperature is too high");
    private String message;

    private BreachType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package TypewiseAlert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TestBreachChecker {
    @Test
    public void testingInferBreach() {
        assertSame(BreachChecker.inferBreach(12, 20, 30), BreachType.TOO_LOW);
        assertSame(BreachChecker.inferBreach(35, 0, 30), BreachType.TOO_HIGH);
        assertSame(BreachChecker.inferBreach(12, 0, 30), BreachType.NORMAL);
        assertSame(BreachChecker.inferBreach(-10, -30, 30), BreachType.NORMAL);
        assertSame(BreachChecker.inferBreach(-10, -5, 30), BreachType.TOO_LOW);
        assertSame(BreachChecker.inferBreach(-1, -10, -5), BreachType.TOO_HIGH);
    }

    @Test
    public void testingBreachClassification() {
        //above threshold
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING,
                CoolingType.HI_ACTIVE_COOLING.getUpperLimit() + 1), BreachType.TOO_HIGH);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING,
                CoolingType.HI_ACTIVE_COOLING.getUpperLimit()), BreachType.TOO_HIGH);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, 55), BreachType.TOO_HIGH);

        //below threshold
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING,
                CoolingType.PASSIVE_COOLING.getLowerLimit() - 1), BreachType.TOO_LOW);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING,
                CoolingType.PASSIVE_COOLING.getLowerLimit() - 1), BreachType.TOO_LOW);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, -10), BreachType.TOO_LOW);

        //threshold
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING,
                CoolingType.MED_ACTIVE_COOLING.getUpperLimit()), BreachType.NORMAL);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING,
                CoolingType.MED_ACTIVE_COOLING.getUpperLimit()), BreachType.NORMAL);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 30), BreachType.NORMAL);

        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 100), BreachType.TOO_HIGH);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING, 25), BreachType.NORMAL);
        assertSame(BreachChecker.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, -25), BreachType.TOO_LOW);
    }

    @Before
    public void testingBreachCheckerObjectCreation() {
        BreachChecker breachChecker = new BreachChecker();
    }
}

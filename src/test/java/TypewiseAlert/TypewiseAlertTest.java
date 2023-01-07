package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(BreachChecker.inferBreach(12, 20, 30) ==
        BreachType.TOO_LOW);
    }
}

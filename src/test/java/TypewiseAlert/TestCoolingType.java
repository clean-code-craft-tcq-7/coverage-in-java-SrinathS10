package TypewiseAlert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCoolingType {
    @Test
    public void testingCoolingTypeLimits() {
        assertTrue(CoolingType.PASSIVE_COOLING.getUpperLimit()<CoolingType.MED_ACTIVE_COOLING.getUpperLimit());
        assertTrue(CoolingType.MED_ACTIVE_COOLING.getUpperLimit()<CoolingType.HI_ACTIVE_COOLING.getUpperLimit());
        assertTrue(CoolingType.MED_ACTIVE_COOLING.getLowerLimit()<=CoolingType.HI_ACTIVE_COOLING.getUpperLimit());
        assertTrue(CoolingType.PASSIVE_COOLING.getLowerLimit() == 0);
    }
}
